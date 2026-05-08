// Problem: Contains Duplicate
// Platform: Leetcode
// Link: https://leetcode.com/problems/contains-duplicate/
// Difficulty: Easy

// Approach:
// We can use a HashSet to store the elements we have seen so far.
// - Iterate through the array, for each element, check if it already exists in the HashSet.
// - If it does, return true (duplicate found).
// - If not, add it to the HashSet.
// - If we finish iterating without finding duplicates, return false.

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

// Alternative Approach:
// We can sort the array and then check for adjacent duplicates.
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) if we sort in place, otherwise O(n) due to the space used by the sorting algorithm.
import java.util.Arrays;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }
}