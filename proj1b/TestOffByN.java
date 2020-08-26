import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy5 = new OffByN(5);
    @Test
    public void testEqual(){
        assertTrue(offBy5.equalChars('a','f'));
        assertFalse(offBy5.equalChars('f','h'));
    }
    // Your tests go here.
}
