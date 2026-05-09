// Problem: Move Zeroes
// Platform: Leetcode
// Link: https://leetcode.com/problems/move-zeroes/
// Difficulty: Easy

// Approach:
// Use two pointers, one to track the position of the last non-zero element and another to iterate through the array.
// When a non-zero element is found, swap it with the element at the last non-zero position and move the last non-zero pointer forward.

// Time Complexity: O(n) - for iterating through the array once.
// Space Complexity: O(1) - only using a constant amount of extra space

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Pointer for the next non-zero position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap the non-zero element with the element at j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                j++;
            }
        }
    }
}