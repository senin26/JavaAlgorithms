import java.util.NoSuchElementException;

public class CustomLeveledTreeMap<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height; // this is the number of levels from the root
        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = 1;
        }
    }

    private Node root = null;

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        else {
            return (isBalanced(node.left) && isBalanced(node.right)) && (Math.abs(height(node.left)-height(node.right))<2);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }


    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node==null) {
            return 0;
        }
        return node.height;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return node.size;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) { //a[key]
        if (key == null) {
            throw new IllegalArgumentException("One can't add a node with key=null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        if (cmp < 0) {
            return get(node.left, key);
        }
        else { //cmp > 0
            return get(node.right, key);
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) { //a[key] = value
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("One can't add a node with key=null");
        }
        if (node == null) {
            return new Node(key, value, 1); // base case
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value; // writing of the new value to the node
        }
        else if (cmp < 0) {
            node.left = put(node.left, key, value);
        }
        else { //cmp > 0
            node.right = put(node.right, key, value);
        }

        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    public Value min() {
        return min(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        else {
            return max(node.right);
        }
    }

    public Value max() {
        return max(root).value;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        else {
            node.left = removeMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    public void removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        else {
            node.right = removeMax(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    public void removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeMax(root);
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        }
        else if (cmp > 0) {
            node.right = remove(node.right, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            node = max(node.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
            tmp = null;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }
}
