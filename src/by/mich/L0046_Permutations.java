package by.mich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array nums of distinct integers,
 * return all the possible permutations. You can return the answer in any order.
 */
public class L0046_Permutations {
    public static void main(String[] args) {
//        List<List<Integer>> permuted = permute(new int[] {1, 2, 3});
        List<List<Integer>> permuted = reposeArray(new int[] {0, 1});
        for(List<Integer> l : permuted) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    // https://leetcode.com/problems/permutations/submissions/888946397/
    // 2ms 42mb
    // 46% 94%
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = IntStream.of(nums).boxed().collect(Collectors.toList());
        return permuteRecursive(numsList, 0, new ArrayList<>());
    }

    public static List<List<Integer>> permuteRecursive(List<Integer> nums, int s, List<List<Integer>> result) {
        if (s == nums.size()) {
            result.add(new ArrayList<>(nums));
        }
        for (int i = s; i < nums.size(); i++) {
            Collections.swap(nums, s, i);
            permuteRecursive(nums, s+1, result);
            Collections.swap(nums, s, i);
        }
        return result;
    }

    // https://leetcode.com/problems/permutations/submissions/888959648/
    // 1ms 42mb
    // 92% 68%
    private static List<List<Integer>> reposeArray(int[] initialArray) {
        int numOfArrays = factorial(initialArray.length);

        List<List<Integer>> result = new ArrayList<>(numOfArrays);
        List<Integer> l = new ArrayList<>();
        l.add(initialArray[0]);
        result.add(0, l);

        List<List<Integer>> tempResult = new ArrayList<>(numOfArrays);
        List<Integer> l2 = new ArrayList<>();
        l2.add(initialArray[0]);
        tempResult.add(0, l2);
        // for base items
        for (int i = 1; i < initialArray.length; i++) {
            if (i <= initialArray.length - 1) {
                result.clear();
            }
            // for existing sub-arrays
            for (int j = 0; j < factorial(i); j++) {
                // for every position in existing sub-array
                List<Integer> baseArray = tempResult.get(j);
                for (int k = 0; k < baseArray.size() + 1; k++) {
                    List<Integer> newArray = new ArrayList<>(baseArray);
                    newArray.add(k, initialArray[i]);
                    result.add(j*(i+1)+k, newArray);
                }
            }
            tempResult.clear();
            for (int j = 0; j < factorial(i+1); j++) {
                tempResult.add(j, new ArrayList<>(result.get(j)));
            }
        }
        return result;
    }

    private static int factorial(int i) {
        return i == 1 ? 1 : i * factorial(i-1);
    }
}
