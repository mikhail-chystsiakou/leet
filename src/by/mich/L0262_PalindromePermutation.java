package by.mich;

/**
 * Given a string s, return true if a permutation of the string could form a
 * palindrome and false otherwise.
 *
 *  s consists of only lowercase English letters.
 */
public class L0262_PalindromePermutation {
    public static void main(String[] args) {
        assert canPermutePalindrome("aab");
    }

    public static boolean canPermutePalindrome(String s) {
        int[] map = new int[32];
        int odds = 0;
        for (char c : s.toCharArray()) {
            map[c-'a']++;
            if (map[c-'a'] % 2 == 1) {
                odds++;
            } else {
                odds--;
            }
        }
        return odds <= 1;
    }
}
