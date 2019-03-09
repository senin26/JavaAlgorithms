import java.util.NoSuchElementException;

public class CustomStack<T> {

    private T[] array = (T[]) new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    private void resize(int capacity) {
        T[] tempArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) { // todo finally understood that i<size, not i<array.length()
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public void push(T t) {
        if (size==array.length)  {
            resize(array.length<<1);
        }
        array[size++] = t;
    }

    public T peek(){
        if (isEmpty()) {
        throw new ArrayIndexOutOfBoundsException();
        }
        return array[size-1];
    }


    public T pop() {
        T out = null;
        out = peek();
        size--;
        if (size == (array.length>>2) && size>0) { // todo this should be in the end of the method
            resize(array.length>>1); // todo array.length>>1, not array.length>>2
        }
        return out;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = size-1; i >= 0; i--) {
            stringBuilder.append(array[i] + " ");
        }
        return stringBuilder.toString();
    }


}
