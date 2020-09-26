package synthesizer;
import java.util.Iterator;
/* Create the basic interface. */
public interface BoundedQueue<T> extends Iterable<T>{
    int capacity(); // return the size of the buffer.
    int fillCount(); // return number of items currently in the buffer.
    void enqueue(T x); // add item x to the end.
    T dequeue(); // delete and return the item from the front.
    T peek(); // return but not delete the item from the front.
    Iterator<T> iterator();

    /* is the buffer empty (is the fillCount equals zero)*/
    default boolean isEmpty() {
        return fillCount() == 0;
    }
    /* is the buffer empty (is the fillCount equals capacity)*/
    default boolean isFull() {
        return fillCount() == capacity();
    }

}
