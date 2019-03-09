public class CustomQueue<T> {

    private T[] array = (T[]) new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }

    public void enqueue(T t) {
        if (size == array.length) {
            resize(array.length<<1);
        }
        array[end] = t;
        end++;
        end %= array.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T out = peek();
        start++;
        size--;
        return out;
    }

    public T peek() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[start];
    }

    private void resize(int capacity) {
        T[] arrayTemp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            arrayTemp[i] = array[(start + i) % array.length];
        }
        array = arrayTemp;
        end = size;
        start = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size ; i++) {
            stringBuilder.append(array[(start + i) % array.length] + " ");
        }
        return stringBuilder.toString();
    }
}
