package by.mich;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
 */
public class L0001_TwoSum {

    public static void main(String[] args) {
        assert Arrays.compare(
            new int[] {0, 2},
            twoSum(new int[] {2,6,7,11,15}, 9)
        ) == 0;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer pos = map.get(target - nums[i]);
            if (pos != null) {
                return new int[] {pos, i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
