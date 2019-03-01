package customArrayList;

import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {

    private int size = 0;
    final int INITIAL_CAPACITY = 10;
    private Object[] list = new Object[INITIAL_CAPACITY];

    public T get(int index) {
        if (index>list.length) throw new ArrayIndexOutOfBoundsException();
        return (T) list[index];
    }

    public void set(int index, Object o) {
        if (index>list.length) throw new ArrayIndexOutOfBoundsException();
        list[index] = o;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (Object current:
             list) {
            if (index<size && !current.equals(o)) {
               index++;
            }
            else if (index<size && current.equals(o)) {
                return index;
            }
        }
        return -1;
    }

    public void add(Object o) {
        if (size<list.length) {
            list[size] = o;
            size++;
        }
        else if (size == list.length) {
            Object[] tempList = new Object[list.length << 1];
            for (int i = 0; i < list.length; i++) {
                tempList[i] = list[i];
            }
            list = tempList;
            list[size] = o;
            size++;
        }
    }

    public boolean remove(Object o) {
        int index = 0;
        boolean res = false;
        for (Object current:
                list) {
            if (index<size && !current.equals(o)) {
                index++;
            }
            else {
                res = true;
                break;
            }
        }
        if (res) {
            Object[] tempList = new Object[list.length-1];
            for (int i = 0; i < list.length-1; i++) {
                if (i<index) {
                    tempList[i] = list[i];
                }
                else {
                    tempList[i] = list[i+1];
                }
            }
        }
        size--;
        return res;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (Object current:
                list) {
            if (current!=null && current.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb = sb.append(list[i] + " ");
        }
        sb.append("]");
        return new String(sb);
    }

    @Override
    public Iterator iterator() {
        return new CustomArrayListIterator();
    }

    private class CustomArrayListIterator implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            T t = (T) list[cursor];
            cursor++;
            return t;
        }
    }

}
