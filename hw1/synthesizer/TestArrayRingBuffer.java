package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(3);
        arb.enqueue(2);
        arb.enqueue(5);
        assertEquals(arb.fillCount,3);
        int actual = arb.peek();
        assertEquals(actual,3);
        arb.enqueue(6);
        arb.enqueue(9);
        int out2 = arb.dequeue();
        assertEquals(out2,3);
        assertEquals(arb.fillCount,4);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
