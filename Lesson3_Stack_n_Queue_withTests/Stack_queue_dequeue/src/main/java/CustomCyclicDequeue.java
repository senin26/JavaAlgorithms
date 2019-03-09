public class CustomCyclicDequeue<T> {

    private int maxSize;
    private int capacity;
    private int left;
    private int right;
    private int size;
    private T[] array;

    public CustomCyclicDequeue(int capacity, int maxSize) {
        if (capacity>maxSize) throw new RuntimeException("Can't set capacity > maxSize");

        if (maxSize%2 != 0) {
            this.maxSize = maxSize+1;
        }
        else this.maxSize = maxSize;

        if (capacity%2 != 0) {
            this.capacity = capacity+1;
        }
        else this.capacity = capacity;

        this.array = (T[]) new Object[capacity];
        this.left = capacity / 2;
        this.right = left + 1;
        this.size = 0;
    }

    public void insertLeft(T t) {
        if (!isFull()) {
            if (size == array.length) {
                resize();
            }
            array[left] = t;
            left--;
            left = (left + array.length) % array.length;
            size++;
            if (size == array.length) {
                resize();
            }
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public void insertRight(T t) {
        if (!isFull()) {
            array[right] = t;
            right++;
            right %= array.length;
            size++;
            if (size == array.length) {
                resize();
            }
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public T getLeft() {
        left = (left + 1)%array.length;
        return array[left];
    }

    public T getRight() {
        right = (right - 1 + array.length)%array.length;
        return array[right];
    }

    public T pullLeft() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("The dequeue is empty!");
        T out = getLeft();
        left = (left + array.length)%array.length;
        size--;
        return out;
    }

    public T pullRight() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("The dequeue is empty!");
        T out = getRight();
        right %= array.length;
        size--;
        return out;
    }

    private void resize() {
        if (capacity < maxSize) {
            if (capacity < maxSize>>1) {
                capacity <<= 1;
            } else {
                capacity = maxSize;
            }

            T[] tempArray = (T[]) new Object[capacity];
            int begin = capacity>>2;

            for (int i = 0; i < size; i++) {
                tempArray[begin + i] = array[(i+left+1)%array.length];
            }
            left = begin - 1;
            right = begin + (begin<<1);
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
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[(i+left+1)%array.length] + " ");
        }
        return stringBuilder.toString();
    }

    public void printDequeue() {
        System.out.println(this.toString());
    }

}