// Problem: 3Sum
// Platform: Leetcode
// Link: https://leetcode.com/problems/3sum/
// Difficulty: Medium

// Approach:
// 1. Sort the array to use two-pointer technique.
// 2. Iterate through the array, fixing one element and using two pointers to find pairs that sum up to the negative of the fixed element.
// 3. Skip duplicate elements to avoid duplicate triplets in the result.

// Time Complexity: O(n^2) - for iterating through the array and using two pointers.
// Space Complexity: O(1) - if we don't consider the space used for the output

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 1. Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // 2. Skip duplicate starting numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 3. Skip duplicate left and right numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }
        return res;
    }
}