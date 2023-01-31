package by.mich;

import java.util.Arrays;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead,
 * be stored in the input character array chars. Note that group lengths
 * that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 */
public class L0443_StringCompression {
    public static void main(String[] args) {
//        System.out.println(compress(new char[] {'a','a','b','b','c','c','c'}));
//        System.out.println(compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(compress(new char[] {'a','a','a','b','b','a','a'}));
//        System.out.println(compress(new char[] {'a'}));
    }

    // https://leetcode.com/problems/string-compression/submissions/889050972/
    // 0ms 41mb
    // 100 75
    public static int compress(char[] chars) {
        if (chars.length == 0) return 0;

        char last = chars[0];
        int strike = 0;
        int p = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == last) {
                strike++;
            } else {
                chars[p] = last;
                last = chars[i];
                if (strike > 1) {
                    p = appendNumber(chars, p+1, strike);
                } else {
                    p++;
                }
                strike = 1;
            }
        }
        chars[p] = last;
        if (strike > 1) {
            p = appendNumber(chars, p+1, strike);
        } else {
            p++;
        }
        System.out.println(Arrays.toString(chars));
        return p;
    }
    public static int appendNumber(char[] chars, int p, int strike) {
        int newPos = p;
        while (strike > 0) {
            char nchar = (char)('0' + (strike % 10));
            strike = strike / 10;
            for (int i = newPos; i > p; i--) {
                char tmp = chars[i];
                chars[i] = chars[i-1];
                chars[i-1] = tmp;
            }
            chars[p] = nchar;
            newPos++;
        }
        return newPos;
    }
}
