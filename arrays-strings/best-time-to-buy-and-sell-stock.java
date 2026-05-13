// Problem: Best Time to Buy and Sell Stock
// Platform: Leetcode
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Difficulty: Easy

// Approach:
// We can use a simple iteration approach.
// - Keep track of the minimum price seen so far.
// - For each day, calculate the profit if we sell on that day (current price - minimum price).
// - Update the maximum profit if the current profit is higher.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update minimum price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update maximum profit
            }
        }
        
        return maxProfit;
    }
}