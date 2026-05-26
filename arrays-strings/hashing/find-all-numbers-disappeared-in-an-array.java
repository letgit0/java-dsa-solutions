// Problem: Find All Numbers Disappeared in an Array
// Platform: LeetCode
// Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Difficulty: Medium

// Approach: Negative Marking
// 1. Iterate through the array and for each number, mark the index corresponding to that number as negative.
// 2. After the first pass, iterate through the array again and collect the indices that are still positive, which correspond to the numbers that are missing from the array.

// Time Complexity: O(n) - we traverse the array a couple of times.
// Space Complexity: O(1) - we are modifying the input array in place and using

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Mark visited elements as negative
        for (int i = 0; i < nums.length; i++) {
            // Get the value (use absolute value because it might have been negated already)
            int val = Math.abs(nums[i]);
            int targetIndex = val - 1;
            
            // If it's not already negative, make it negative
            if (nums[targetIndex] > 0) {
                nums[targetIndex] = -nums[targetIndex];
            }
        }
        
        // Step 2: Find which indices are still positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // The number (i + 1) was never encountered
                result.add(i + 1);
            }
        }
        
        return result;
    }
}