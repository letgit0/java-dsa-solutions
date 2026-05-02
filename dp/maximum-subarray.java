// Problem: Maximum Subarray
// Platform: LeetCode
// Link: https://leetcode.com/problems/maximum-subarray/
// Difficulty: Medium

// Approach: Kadane's Algorithm
// At each index, decide whether to:
// 1) Start a new subarray from current element
// 2) Extend the previous subarray
//
// currentMax = max(nums[i], currentMax + nums[i])
// globalMax tracks the maximum subarray sum found so far

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length;

    int currentMax = nums[0];
    int globalMax = nums[0];

    for (int i = 1; i < n; i++) {
      // Either take current element alone or extend previous subarray
      currentMax = Math.max(nums[i], currentMax + nums[i]);

      // Update global maximum if needed
      globalMax = Math.max(globalMax, currentMax);
    }

    return globalMax;
  }
}