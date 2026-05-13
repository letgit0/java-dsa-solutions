// Problem: Remove Duplicates From Sorted Array
// Platform: Leetcode
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Difficulty: Easy

// Approach:
// Since the array is sorted, we can use a two-pointer technique.
// - Use one pointer to iterate through the array.
// - Use another pointer to keep track of the position where the next unique element should be placed.
// - If the current element is different from the previous one, place it at the position indicated by the second pointer.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int uniqueIndex = 1; // Start from the second element
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        
        return uniqueIndex; // The length of the array with unique elements
    }
}