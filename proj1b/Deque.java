/**  create interface deque.*/
public interface Deque<T> {
    /** add element to the front.*/
    void addFirst(T item);

    /** add element to the last.*/
    void addLast(T item);

    /** check if is empty.*/
    boolean isEmpty();

    /** return the size.*/
    int size();

    /** print one by one.*/
    void printDeque();

    /** remove and return the first element.*/
    T removeFirst();

    /** remove and return the last element.*/
    T removeLast();

    /** fetch the item.*/
    T get(int index);
}
