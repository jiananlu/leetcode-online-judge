/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] peakSells = new int[length];
        peakSells[length - 1] = prices[length - 1];
        
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > peakSells[i + 1]) {
                peakSells[i] = prices[i];
            }
            else {
                peakSells[i] = peakSells[i + 1];
            }
        }
        
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int profit = peakSells[i] - prices[i];
            if (profit > max) {
                max = profit;
            }
        }
        
        return max;
    }
}