import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("non"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("catc"));

    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator comparator = new OffByOne();

        assertTrue(palindrome.isPalindrome("", comparator));
        assertTrue(palindrome.isPalindrome("o", comparator));
        assertTrue(palindrome.isPalindrome("flake", comparator));
        assertFalse(palindrome.isPalindrome("noon", comparator));
    }

    @Test
    public void testIsPalindromeOffByN() {
        CharacterComparator comparator = new OffByN(1);

        assertTrue(palindrome.isPalindrome("", comparator));
        assertTrue(palindrome.isPalindrome("o", comparator));
        assertTrue(palindrome.isPalindrome("flake", comparator));
        assertFalse(palindrome.isPalindrome("noon", comparator));
    }
}