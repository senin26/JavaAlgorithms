/**
 * This queue is not circular, but the problem of unused elements is solved
 * by trimming of the array in case of first > capacity/2. But this is not
 * as effective as circular queue
 * */

public class CustomTrimmableQueue<T> {

        private int maxLen;
        private int capacity;
        private int end;
        private int first;
        private T[] array;

        public CustomTrimmableQueue(int capacity, int maxLen) {
            this.maxLen = maxLen;
            this.capacity = capacity;
            this.array = (T[]) new Object[capacity];
            this.first = 0;
        }

        public void enqueue(T t) {
            if (!isFull()) {
                if (end == capacity) {
                    resize();
                }
                array[end] = t;
                end++;
            }
            else throw new ArrayIndexOutOfBoundsException();
        }

        public T dequeue() {
            if (!isEmpty()) {
                if (needToTrim()) {
                    trim();
                }
                T out = peek();
                array[first] = null;
                first++;
                return out;
            }
            else throw new ArrayIndexOutOfBoundsException();
        }

        public T peek() {
            if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty");
            return array[first];
        }

        private void trim() {
            T[] tempQueue = (T[]) new Object[capacity];
            for (int i = first; i < end; i++) {
                tempQueue[i-first] = this.array[i];
            }
            end = end - first;
            first = 0;
            this.array = tempQueue;
        }

        private boolean needToTrim() {
            if (first >= capacity/2){
             return true;
            }
            return false;
        }

        private void resize() {
            if (capacity < maxLen) {
                if (capacity < maxLen /2) {
                    capacity *= 2;
                }
                else {
                    capacity = maxLen;
                }
                T[] tempArray = (T[]) new Object();
                for (int i = 0; i < this.array.length; i++) {
                    tempArray[i] = this.array[i];
                }
                this.array = tempArray;
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