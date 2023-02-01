package by.mich;

import java.util.Arrays;

/**
 * Given an array nums. We define a running sum of an array as
 * runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 */
public class L1480_RunningSumOfArray {
    public static void main(String[] args) {
        assert Arrays.compare(
            new int[]{1,2,3,4},
            runningSum(new int[]{1,3,6,10})
        ) == 0;
    }

    // https://leetcode.com/problems/running-sum-of-1d-array/description/?envType=study-plan&id=level-1
    public static int[] runningSum(int[] nums) {
        if (nums.length == 0) return new int[0];

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i-1];
        }
        return result;
    }
}
