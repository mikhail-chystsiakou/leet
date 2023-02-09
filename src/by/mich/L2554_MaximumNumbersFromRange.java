package by.mich;

import java.util.Arrays;

/**
 * You are given an integer array banned and two integers n and maxSum.
 * You are choosing some number of integers following the below rules:
 *
 * The chosen integers have to be in the range [1, n].
 * Each integer can be chosen at most once.
 * The chosen integers should not be in the array banned.
 * The sum of the chosen integers should not exceed maxSum.
 * Return the maximum number of integers you can choose following the mentioned rules.
 */
public class L2554_MaximumNumbersFromRange {
    // https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/submissions/891360027
    // 62 50
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int res = 0;

        for (int i = 1, j = 0, sum = 0; i <= n; i++) {
            boolean ban = false;
            while (j < banned.length && banned[j] == i) {
                j++;
                ban = true;
            }
            if (ban) continue;

            sum += i;
            if (sum > maxSum) break;
            res++;
        }

        return res;
    }
}
