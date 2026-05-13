// Problem: Left and Right Sum Differences
// Platform: Leetcode
// Link: https://leetcode.com/problems/left-and-right-sum-differences/
// Difficulty: Easy

// Approach:
// 1. Calculate the total sum of the array.
// 2. Iterate through the array, maintaining a running sum of the left side.
// 3. For each element, calculate the right sum by subtracting the current element from the total sum.
// 4. Compute the absolute difference between the left and right sums and store it in the result array.

// Time Complexity: O(n) - for iterating through the array twice.
// Space Complexity: O(n) - for the result array.

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            int right = total - nums[i];
            result[i] = Math.abs(left - right);
            total -= nums[i];
            left += nums[i];
        }
        return result;
    }
}