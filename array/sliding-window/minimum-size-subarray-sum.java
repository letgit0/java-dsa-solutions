// Problem: Minimum Size Subarray Sum
// Platform: Leetcode
// Link: https://leetcode.com/problems/minimum-size-subarray-sum/
// Difficulty: Medium

// Approach:
// 1. Use a sliding window to find the minimum size subarray with sum >= target.
// 2. Expand the window by moving the right pointer and add elements to the current sum.
// 3. When the sum meets or exceeds the target, try to shrink the window from the left while maintaining the condition.
// 4. Keep track of the minimum window size found during the process.

// Time Complexity: O(n) - where n is the length of the array.
// Space Complexity: O(1) - as we are using only a few variables to store intermediate results.

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // Try to shrink the window from the left while the sum is greater than or equal to target
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}