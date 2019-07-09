import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    // Your tests go here.
    @Test
    public void testOffByOne() {
        CharacterComparator obo = new OffByN(1);
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('r', 'q'));
        assertFalse(obo.equalChars('a', 'A'));
    }

    // Your tests go here.
    @Test
    public void testOffByTwo() {
        CharacterComparator obo = new OffByN(2);
        assertTrue(obo.equalChars('a', 'c'));
        assertFalse(obo.equalChars('a', 'b'));
    }
}