public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque <Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            char charAtZero = word.charAt(i);
            result.addLast(charAtZero);
        }
        return result;
    }

    private boolean helper(Deque<Character> Item) {
        if (Item.size() <= 1) {
            return true;
        }
        char a = Item.removeFirst();
        char b = Item.removeLast();

        if (a == b){
            return helper(Item);
        }
        else{
            return false;
        }
    }

    public boolean isPalindrome(String word) {
        Deque <Character> first = wordToDeque(word);
        return helper(first);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque <Character> item = wordToDeque(word);
        while (item.size() > 1) {
            char a = item.removeFirst();
            char b = item.removeLast();
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }
}
