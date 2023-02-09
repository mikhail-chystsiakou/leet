package by.mich;

/**
 * Given two strings s and t, return true if s is a subsequence of t,
 * or false otherwise.
 *
 * A subsequence of a string is a new string that is formed
 * from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class L0392_IsSubsequence {
    //https://leetcode.com/problems/is-subsequence/submissions/891253540/
    // 40 55
    public static boolean isSubsequence(String s, String t) {
        int si = 0;
        for (int ti = 0; si < s.length() && ti < t.length(); ti++) {
            if (s.charAt(si) == t.charAt(ti)) si++;
        }
        return si == s.length();
    }
}
