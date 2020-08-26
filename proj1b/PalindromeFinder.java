/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            CharacterComparator ca = new OffByN(4);
            if (word.length() >= minLength && palindrome.isPalindrome(word,ca)) {
                System.out.println(word);
            }
        }
    }
}
