// Problem: Delete and Earn
// Platform: LeetCode
// Link: https://leetcode.com/problems/delete-and-earn/
// Difficulty: Medium

// Approach:
// Convert the problem into a "House Robber" style DP.
//
// Step 1: Build a points array where points[i] = total value gained from all occurrences of i.
// Step 2: Apply DP relation:
//   - Skip i: dp[i - 1]
//   - Take i: dp[i - 2] + points[i]
//   => dp[i] = max(dp[i - 1], dp[i - 2] + points[i])
//
// Time Complexity: O(n + maxValue)
// Space Complexity: O(maxValue)

class Solution {
  public int deleteAndEarn(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // Find maximum value in nums
    int maxValue = nums[0];
    for (int num : nums) {
      maxValue = Math.max(maxValue, num);
    }

    // points[i] = total contribution of value i
    int[] points = new int[maxValue + 1];
    for (int num : nums) {
      points[num] += num;
    }

    int[] dp = new int[maxValue + 1];
    int maxPoints = 0;

    for (int i = 0; i <= maxValue; i++) {
      if (i < 2) {
        dp[i] = points[i];
      } else {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
      }
      maxPoints = Math.max(maxPoints, dp[i]);
    }

    return maxPoints;
  }
}