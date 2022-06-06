public class Palindrome {
    /** move all characters of a string into a list.
     *  @param a word
     *  @return a list of characters
     */
    public Deque<Character> wordToDeque (String word) {
        Deque<Character> list = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            list.addLast(word.charAt(i));
        }
        return list;
    }

    /** check if a string is palindrome
     * @param a word
     * @return true if the given word is a palindrome, false otherwise.
     */
    public boolean isPalindrome (String word) {
        Deque<Character> list = wordToDeque(word);
        while (list.size() > 1) {
            Character a = list.removeFirst();
            Character b = list.removeLast();
            if (!a.equals(b)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome (String word, CharacterComparator cc) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
