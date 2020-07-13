package circularQueue;

/**
 * This is a circular queue
 * */

public class CustomCircularQueue<T> {

        private int maxLen;
        private int capacity;
        private int end;
        private int first;
        private T[] array;
        private int size;

        public CustomCircularQueue(int capacity, int maxLen) {
            this.maxLen = maxLen;
            this.capacity = capacity;
            this.array = (T[]) new Object[capacity];
            this.first = 0;
            this.end = 0;
            this.size = 0;
        }

        public void enqueue(T t) {
            if (!isFull()) {
                if (size == capacity) {
                    resize();
                }
                getEnd();
                array[end] = t;
                size++;
            }
            else throw new ArrayIndexOutOfBoundsException();
        }

        public T dequeue() {
            if (!isEmpty()) {
                T out = peek();
                array[first] = null;
                first++;
                size--;
                return out;
            }
            else throw new ArrayIndexOutOfBoundsException();
        }

        public T peek() {
            if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Queue is empty");
            return array[first];
        }

        private int getEnd() {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    end = i;
                    return end;
                }
            }
            return end;
        }

        private void resize() {
            if (capacity < maxLen) {
                if (capacity < maxLen /2) {
                    capacity *= 2;
                }
                else {
                    capacity = maxLen;
                }
                T[] tempArray = (T[]) new Object[capacity];
                for (int i = 0; i < this.array.length; i++) {
                    tempArray[i] = this.array[i];
                }
                this.array = (T[]) tempArray;
            }
        }

        public int size() {
            return end - first;
        }

        public boolean isEmpty() {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null)
                    return false;
            }
            return true;
        }

        public boolean isFull() {
            return end == maxLen;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < array.length ; i++) {
                if (array[i]!=null) {
                    stringBuilder.append(array[i] + "\n");
                }
            }
            return stringBuilder.toString();
        }

        public void printQueue() {
            System.out.println(this.toString());
        }

    }