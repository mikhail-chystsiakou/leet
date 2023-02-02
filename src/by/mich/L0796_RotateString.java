package by.mich;

/**
 * Given two strings s and goal, return true if and only if s can become goal
 * after some number of shifts on s.
 *
 * A shift on s consists of moving the leftmost character of s to the
 * rightmost position.
 *
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 */
public class L0796_RotateString {
    public static void main(String[] args) {
        assert rotateString("abcd", "bcda");
    }

    // https://leetcode.com/problems/rotate-string/submissions/889577514/
    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) return true;
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < goal.length(); i++) {
            if (s.charAt(0) != goal.charAt(i)) {
                continue;
            }
            int si = 1;
            for (; si < s.length(); si++) {
                int goalIndex = (i + si) % goal.length();
                if (s.charAt(si) != goal.charAt(goalIndex)) {
                    si = 0;
                    break;
                }
            }
            if (si == s.length()) {
                return true;
            }
        }
        return false;
    }
}
