package by.mich;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters
 * '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */
public class L0020_ValidParentheses {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/valid-parentheses/submissions/890363582/
    // 99 56
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> d = new ArrayDeque<>(chars.length);
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (Character c : chars) {
            if (map.containsKey(c)) {
                Character closing = d.poll();
                if (closing != map.get(c))
                    return false;
            } else {
                d.push(c);
            }
        }
        return d.isEmpty();
    }
}
