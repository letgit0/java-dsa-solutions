// Problem: Maximum Average Subarray I
// Platform: Leetcode
// Link: https://leetcode.com/problems/maximum-average-subarray-i/
// Difficulty: Easy

// Approach:
// 1. Use a sliding window of size k to calculate the sum of the first k elements.
// 2. Slide the window across the array, updating the sum by adding the new element and removing the element that is sliding out of the window.
// 3. Keep track of the maximum sum encountered and return the average by dividing it by k at the end.

// Time Complexity: O(n) - where n is the length of the array.
// Space Complexity: O(1) - as we are using a constant amount of space to store the sum and maximum sum.

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k]; // Add new element and remove the old element
            maxSum = Math.max(maxSum, sum); // Update max sum if current sum is greater
        }

        return (double) maxSum / k; // Return the average
    }
}