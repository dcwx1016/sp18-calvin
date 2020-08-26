public class ArrayDeque <T>{
    public T[] first;
    public int size;
    public int nextFirst;
    public int nextLast;

    public ArrayDeque() {
        size = 0;
        first = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    public void addFirst(T item) {
        first[nextFirst] = item;
        nextFirst += -1;
        size += 1;
        if (nextFirst == -1) {
              nextFirst = first.length - 1;
          }
        resize();
    }

    public void addLast(T item) {
        first[nextLast] = item;
        nextLast += 1;
        size += 1;
        if (nextLast == first.length) {
                nextLast = 0;
            }
        resize();
    }

    public void resize() {
        if (nextLast == nextFirst) {
            T[] after = (T[]) new Object[first.length * 2];
            nextFirst = first.length - 1;
            nextLast = nextFirst + size + 1;
            System.arraycopy(after,first.length,first,nextFirst + 1,first.length - nextFirst - 1);
            System.arraycopy(after,first.length - nextFirst - 1,first,0, nextLast - 1);
            first = after;
        }

    }

    public boolean isEmpty() {
        if (first[nextFirst + 1] == null) {
            return true;
        } else {
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
        T result;
        if(nextFirst == first.length - 1) {
            result = first[0];
            first[0] = null;
        } else{
            result = first[nextFirst + 1];
            first[nextFirst + 1] = null;
        }
        size += -1;
        return result;
    }

    public T removeLast() {
        T result;
        if(nextLast == 0) {
            result = first[first.length - 1];
            first[first.length - 1] = null;
        } else{
            result = first[nextLast - 1];
            first[nextLast - 1] = null;
        }
        size += -1;
        return result;
    }

    public T get(int index) {
        if ( nextFirst + index < first.length) {
            return first[nextFirst + index];
        } else{
            return first[nextFirst + index - first.length];
        }

    }

    public ArrayDeque(ArrayDeque other) {
        first = (T[]) new Object[other.first.length];
        System.arraycopy(first,0,other,0,other.size);
    }
}
