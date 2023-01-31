package by.mich;

/**
 * Given two strings s and t, return true if they are both one edit
 * distance apart, otherwise return false.
 *
 * A string s is said to be one distance apart from a string t if you can:
 *
 * Insert exactly one character into s to get t.
 * Delete exactly one character from s to get t.
 * Replace exactly one character of s with a different character to get t.
 */
public class L0161_OneEditDistance {
    public static void main(String[] args) {
        assert isOneEditDistance("ab", "abc");
    }

    // https://leetcode.com/problems/one-edit-distance/submissions/889037493/
    // 1ms 41mb
    // 92 48
    public static boolean isOneEditDistance(String s, String t) {
        boolean editFound = false;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) == t.charAt(j)) continue;

            if (editFound) {
                return false;
            }
            editFound = true;

            // delete or insert
            if (s.length() == t.length() + 1) {
                j--;
            } else if (s.length() == t.length() - 1) {
                i--;
            }
        }
        if (!editFound && (s.length() == t.length()+1 || s.length() == t.length()-1)) {
            editFound = true;
        }
        return editFound;
    }
}
