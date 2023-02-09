package by.mich;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive integers nums, return an array answer
 * that consists of the digits of each integer in nums after separating
 * them in the same order they appear in nums.
 *
 * To separate the digits of an integer is to get all the digits
 * it has in the same order.
 *
 * For example, for the integer 10921,
 * the separation of its digits is [1,0,9,2,1].
 */
public class L2253_SeparateDigitsInArray {

    // https://leetcode.com/problems/separate-the-digits-in-an-array/submissions/891334453/
    // 100 100
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        for (int num : nums) {
            j = 0;
            while (num > 0) {
                result.add(i, num % 10);
                num = num / 10;
                j++;
            }
            i+=j;
        }

        int[] res = new int[result.size()];
        for (int n = 0; n < result.size(); n++) {
            res[n] = result.get(n);
        }
        return res;
    }
}
