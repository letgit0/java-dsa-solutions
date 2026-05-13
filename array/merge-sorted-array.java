// Problem: Merge Sorted Array
// Platform: Leetcode
// Link: https://leetcode.com/problems/merge-sorted-array /
// Difficulty: Easy

// Approach:
// 1. Use three pointers: one for the end of the first array, one for the end of the second array, and one for the end of the merged array.
// 2. Compare elements from both arrays and place the larger element at the end of the merged array.
// 3. Continue until all elements are merged.
// loop condition is while (j >= 0). Because if nums2 is empty, any remaining numbers in nums1 are already in their correct, sorted positions at the front of the array.

// Time Complexity: O(m + n) - where m and n are the lengths of the two arrays.
// Space Complexity: O(1) - as we are merging in-place.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Last actual element in nums1
        int j = n - 1; // Last element in nums2
        int k = m + n - 1; // Last slot in nums1
        
        while (j >= 0) {
            // If nums1 still has elements and its element is bigger...
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                // Otherwise, nums2 has the bigger (or only remaining) element
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}