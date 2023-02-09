package by.mich;

/**
 * You are given an array prices where prices[i] is the price of a given
 * stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day
 * to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class L0121_BestTimeToBuy {
    public static void main(String[] args) {
        System.out.println((1+2) / 2.0);
    }
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/891502498/
    // 69 80
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
