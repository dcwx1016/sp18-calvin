package synthesizer;
/** Create a subclass that implements BoundedQueue.
 * @author zouyang. */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /** Create an int variable. */
    protected int fillCount;
    /** Create an int variable. */
    protected int capacity;
    /** Create a getter method @return. */
    public int capacity() {
        return capacity;
    }
    /** Create a getter method @return. */
    public int fillCount() {
        return fillCount;
    }
}
