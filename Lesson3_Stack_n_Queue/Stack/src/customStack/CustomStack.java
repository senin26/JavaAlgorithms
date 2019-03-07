package customStack;

public class CustomStack<T> {

    private int maxSize;
    private int capacity;
    private int top;
    private T[] array;

    public CustomStack(int capacity, int maxSize) {
        this.maxSize = maxSize;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.top = 0;
    }

    public void push(T t) {
        if (!isFull()) {
            if (top == capacity) {
                resize();
            }
            array[top] = t;
            top++;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public T pop() {
        if (!isEmpty()) {
            T peek = peek();
            array[top-1] = null;
            top--;
            return peek;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public T peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        return array[top-1];
    }

    private void resize() {
        if (capacity < maxSize) {
            if (capacity < maxSize/2) {
                capacity *= 2;
            }
            else {
                capacity = maxSize;
            }
            T[] tempArray = (T[]) new Object[capacity];
            for (int i = 0; i < this.array.length; i++) {
                tempArray[i] = this.array[i];
            }
            this.array = tempArray;
        }
    }
    
    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == maxSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = (top-1); i >=0 ; i--) {
            stringBuilder.append(array[i] + "\n");
        }
        return stringBuilder.toString();
    }

    public void printStack() {
        System.out.println(this.toString());
    }

}
