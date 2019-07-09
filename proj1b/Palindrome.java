public class Palindrome {

    /**
     * Returns a Deque where the characters appear in the same order as in the String.
     *
     * For example, if the word is “persiflage”,
     *      then the returned Deque should have ‘p’ at the front, followed by ‘e’, and so forth.
     *
     * @param word - a String
     * @return a deque of characters
     *
     */
    public Deque<Character> wordToDeque(String word) {

        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++)
            deque.addLast(word.charAt(i));

        return deque;
    }

    // Returns True if a word is a palindrome
    public boolean isPalindrome(String word) {
        int len = word.length();
        if (len == 0 || len == 1)
            return true;

        if (word.charAt(0) == word.charAt(len - 1))
            return isPalindrome(word.substring(1, len - 1));
        else
            return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int len = word.length();
        if (len == 0 || len ==  1)
            return true;

        if (cc.equalChars(word.charAt(0), word.charAt(len - 1)))
            return isPalindrome(word.substring(1, len - 1), cc);
        else
            return false;
    }
}
