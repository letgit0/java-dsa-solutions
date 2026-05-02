// Problem: Coin Change
// Platform: LeetCode
// Link: https://leetcode.com/problems/coin-change/
// Difficulty: Medium

// Approach:
// dp[i] = minimum number of coins required to make amount i
// Base Case: dp[0] = 0 (0 coins needed to make amount 0)
//
// For each amount i, try every coin:
// If we pick coin as the last coin, we solve subproblem (i - coin)
//
// We initialize dp with (amount + 1), which acts as "infinity"
// because the maximum coins needed can never exceed 'amount'
// (e.g., all 1-value coins)


// Time Complexity: O(amount * coins.length)
// Space Complexity: O(amount)

import java.util.Arrays;

class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];

    // Initialize with a value greater than any possible answer
    Arrays.fill(dp, amount + 1);

    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        }
      }
    }

    // If dp[amount] is still greater than amount, it's not possible
    return dp[amount] > amount ? -1 : dp[amount];
  }
}