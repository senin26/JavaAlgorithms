public class CustomDequeue<T> {

    private int maxSize;
    private int capacity;
    private int left;
    private int right;
    private int size;
    private T[] array;

    public CustomDequeue(int capacity, int maxSize) {
        this.maxSize = maxSize;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.left = capacity / 2;
        this.right = left + 1;
        this.size = 0;
    }

    public void insertLeft(T t) {
        if (!isFull()) {
            if (left == -1) {
                resize();
            }
            array[left] = t;
            left--;
            size++;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public void insertRight(T t) {
        if (!isFull()) {
            if (right == capacity) {
                resize();
            }
            array[right] = t;
            right++;
            size++;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public T getLeft() {
        return array[left+1];
    }

    public T getRight() {
        return array[right-1];
    }

    public T pullLeft() {
        T out = getLeft();
        array[left+1] = null;
        left++;
        size--;
        return out;
    }

    public T pullRight() {
        T out = getRight();
        array[right-1] = null;
        right--;
        size--;
        return out;
    }

    private void resize() {
        if (capacity < maxSize) {
            if (capacity < maxSize / 2) {
                capacity *= 2;
            } else {
                capacity = maxSize;
            }
            T[] tempArray = (T[]) new Object[capacity];
            int begin = 0;
            if (left == -1) {
                begin = capacity / 2;
            }

            for (int i = (left+1); i < right; i++) {
                tempArray[begin + i] = array[i];
            }
            if (left == -1) {
                left = begin - 1;
                right += capacity/2;
            }
            this.array = tempArray;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = (left + 1); i < right; i++) {
            stringBuilder.append(array[i] + " ");
        }
        return stringBuilder.toString();
    }

    public void printDequeue() {
        System.out.println(this.toString());
    }

}