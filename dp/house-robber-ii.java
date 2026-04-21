// Problem: House Robber II
// Platform: LeetCode
// Link: https://leetcode.com/problems/house-robber-ii/
// Difficulty: Medium

// Approach: Break circular case into two linear robberies

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int rob(int[] nums) {
    int n = nums.length;

    if (n == 1) return nums[0];

    // Exclude last house OR exclude first house
    return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
  }

  private int robRange(int[] nums, int start, int end) {
    int prev2 = 0; // dp[i-2]
    int prev1 = 0; // dp[i-1]

    for (int i = start; i < end; i++) {
      int curr = Math.max(prev1, prev2 + nums[i]);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
}