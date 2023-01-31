package by.mich;

/**
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters
 * exactly once.
 *
 * s and t consist of lowercase English letters.
 */
public class L0242_ValidAnagram {
    public static void main(String[] args) {
        assert isAnagram("abc", "bac");
    }

    // https://leetcode.com/problems/valid-anagram/submissions/888707117/
    // 84.56% 67.57%
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] checker = new int[26];
        for(int i = 0; i < s.length(); i++) {
            checker[s.charAt(i) - 'a']++;
            checker[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < t.length(); i++) {
            if (checker[s.charAt(i) - 'a'] != 0) return false;
        }
        return true;
    }
}
