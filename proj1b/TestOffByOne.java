import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testEqual(){
        assertTrue(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('a','b'));
    }
    // Your tests go here.
}
