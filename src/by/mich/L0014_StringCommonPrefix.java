package by.mich;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class L0014_StringCommonPrefix {

    public static void main(String[] args) {
        assert longestCommonPrefix(
            new String[]{
                "abc",
                "ababbdd"
            }).equals("ab");
    }

    public static String longestCommonPrefix(String[] strs) {
        int prefixEnd = 0;
        outer: for (int i = 0; i < strs[0].length(); i++) {
            char s = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || s != strs[j].charAt(i)) break outer;
            }
            prefixEnd++;
        }
        return strs[0].substring(0, prefixEnd);
    }
}
