// Problem: House Robber
// Platform: LeetCode
// Link: https://leetcode.com/problems/house-robber/
// Difficulty: Medium

// Approach: Dynamic Programming (Optimized)

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int rob(int[] nums) {
    int prev2 = 0; // dp[i-2]
    int prev1 = 0; // dp[i-1]

    for (int num : nums) {
      int curr = Math.max(prev1, prev2 + num);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
}