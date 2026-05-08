// Problem: Two Sum
// Platform: Leetcode
// Link: https://leetcode.com/problems/two-sum/
// Difficulty: Easy

// Approach:
// We can use a HashMap to store the numbers we have seen so far and their corresponding indices.
// - Iterate through the array, for each element, calculate the complement (target - current element).
// - Check if the complement exists in the HashMap.

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> idx = new HashMap<>();
        int n = nums.length;
        for(int i =0 ; i<n; i++){
            if(idx.containsKey(target-nums[i])){
                return new int[] {i, idx.get(target-nums[i])};
            }
            idx.put(nums[i],i);
        }
        return new int[0];
    }
}

