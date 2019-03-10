import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements Iterable<T> {

    public Iterator<T> iterator() {
        return new CustomLinkedListIterator();
    }

    private class CustomLinkedListIterator implements Iterator<T> {

        Node current = first;

        public void remove() {
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = current.t;
            current = current.next;
            return t;
        }
    }

    private class Node {
        T t;
        Node next;
        Node previous;

        public Node(Node previous, T t, Node next) {
            this.previous = previous;
            this.t = t;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return first.t;
    }

    public void addFirst(T t) {
        Node oldFirst = first;
        first = new Node(null, t, oldFirst);
        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.previous = first;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node second = first.next;
        T t = first.t;
        first.t = null;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()) {
            last = null;
        }
        else {
            second.previous = null;
        }
        return t;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return last.t;
    }

    public void addLast(T t) {
        Node oldLast = last;
        last = new Node(oldLast, t, null);
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T t = last.t;
        Node previous = last.previous;
        last.previous = null;
        last = previous;
        size--;
        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return t;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current.t;
    }

    public void set(int index, T t) { //a[index] = t;
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        current.t = t;
    }

    public int indexOf(T t) {
        Node current = first;
        int currentIndex = 0;
        while (current != null && !current.t.equals(t)) {
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }

    public boolean contains(T t) {
        return indexOf(t) > -1;
    }

    public T remove(T t) {
        Node current = first;

        while (current != null && !current.t.equals(t)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            return removeFirst();
        }
        if (current == last) {
            return removeLast();
        }
        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.previous = null;
        current.next = null;
        return current.t;
    }

    public void add(int index, T t) { //addBefore
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(t);
            return;
        }
        else if (index == size) {
            addLast(t);
            return;
        }

        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(current.previous, t, current);
        Node previous = current.previous;
        previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node current = first;
        while (current != null) {
            s.append(current.t.toString());
            s.append(" ");
            current = current.next;
        }
        return s.toString();
    }
}