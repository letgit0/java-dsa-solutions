// Problem: Sort Colors
// Platform: LeetCode
// Link: https://leetcode.com/problems/sort-colors/
// Difficulty: Medium

// Approach: The Dutch National Flag Algorithm (a three-pointer approach).
// Use three pointers to partition the array into three regions: red (0), white (1), and blue (2).
// Move all 0s to the left, all 2s to the right, and keep 1s in the middle.

// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int low = 0; // Pointer for the next position of 0
        int mid = 0; // Pointer for the current element
        int high = nums.length - 1; // Pointer for the next position of 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}