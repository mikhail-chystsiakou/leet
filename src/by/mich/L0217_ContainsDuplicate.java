package by.mich;

import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 */
public class L0217_ContainsDuplicate {
    public static void main(String[] args) {
        assert containsDuplicate(
            new int[] {170,-368,192,170,309,-615,-237}
        );
    }

    // https://leetcode.com/problems/contains-duplicate/submissions/888667646/
    // 3ms 56MB
    // 99.86% 38.90%
    public static boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j+1] == nums[j]) return true;
                if (nums[j+1] < nums[j]) {
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    // https://leetcode.com/problems/contains-duplicate/submissions/888700928/
    // 19 ms 56.6 MB
    // 46.15% 42.22%
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }


    public static boolean containsDuplicateSet(int[] nums) {
        Set<Integer> counts = new HashSet<>(nums.length);
        for(int i : nums) {
            if (!counts.add(i)) return true;
        }
        return false;
    }

    public static boolean containsDuplicateMap(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i : nums) {
            counts.merge(i, 1, (Integer o, Integer n) -> o+1);
        }
        for(Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (e.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
}
