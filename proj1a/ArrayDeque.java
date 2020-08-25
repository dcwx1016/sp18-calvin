public class ArrayDeque <T>{
    public T[] first;
    private int size;

    public ArrayDeque() {
        size = 0;
        first = (T[]) new Object[8];;
    }

    public void addFirst(T item) {
        T[] a = (T[]) new Object[size + 1];
        System.arraycopy(a,1,first,1,size);
        first = a;
        first[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == first.length) {
            T[] a = (T[]) new Object[size + 1];
            System.arraycopy(a,0,first,0,size);
            first = a;
        }
        first[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        if (first[0] == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i ++) {
            System.out.print(first[i] + " ");
        }
        System.out.println(" ");
    }

    public T removeFirst() {
        T outcome = first[0];
        if (outcome != null) {
            T[] a = (T[]) new Object[size - 1];
            System.arraycopy(a,1,first,1,size - 1);
            first = a;
            size += -1;
        }
        return outcome;
    }

    public T removeLast() {
        T outcome = first[size];
        if (outcome != null) {
            T[] a = (T[]) new Object[size - 1];
            System.arraycopy(a,0,first,0,size - 1);
            first = a;
            size += -1;
        }
        return outcome;
    }

    public T get(int index) {
        return first[index];
    }

    public ArrayDeque(ArrayDeque other) {
        first = (T[]) new Object[other.first.length];;
        System.arraycopy(first,0,other,0,other.size);
    }
}
