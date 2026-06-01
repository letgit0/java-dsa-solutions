// Problem: Next Permutation
// Platform: LeetCode
// Link: https://leetcode.com/problems/next-permutation/
// Difficulty: Medium

// Approach:
// Find the largest index i such that nums[i] < nums[i + 1]. If no such index exists, the permutation is the last permutation.
// Find the largest index j such that nums[i] < nums[j].
// Swap nums[i] and nums[j].
// Reverse the subarray from nums[i + 1] to the end.

// Time Complexity: O(n) - each operation is linear in the size of the array.
// Space Complexity: O(1) - in-place transformation.

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first element from the right that is smaller than its next element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If such an element is found (meaning the array isn't entirely in descending order)
        if (i >= 0) {
            int j = n - 1;
            // Step 2: Find the element from the right that is just larger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap them
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix starting from i + 1 to the end
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}