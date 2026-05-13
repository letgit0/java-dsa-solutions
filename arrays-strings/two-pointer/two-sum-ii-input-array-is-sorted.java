// Problem: Two Sum II - Input Array Is Sorted
// Platform: Leetcode
// Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Difficulty: Medium

// Approach:
// Use two pointers, one at the beginning and one at the end of the array.
// Move the pointers towards each other based on the sum of the elements they point to.
// If the sum equals the target, return the indices.
// If the sum is less than the target, move the left pointer to the right.
// If the sum is greater than the target, move the right pointer to the left.

// Time Complexity: O(n) - for iterating through the array once.
// Space Complexity: O(1) - only using a constant amount of extra space

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int curr = numbers[i] + numbers[j];
            if(curr > target){
                j--;
            }else if(curr < target){
                i++;
            }else{
                return new int[]{i+1, j+1};
            }
        }
        return null;
    }
}