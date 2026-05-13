// Problem: Continuous Subarray Sum
// Platform: Leetcode
// Link: https://leetcode.com/problems/continuous-subarray-sum/
// Difficulty: Medium

// Approach:
// 1. Use a hash map to store the remainder of the cumulative sum modulo k and its index.
// 2. If the same remainder appears again, it means the subarray between these indices has a sum divisible by k.
// 3. Keep track of the minimum length of such subarrays.

// Time Complexity: O(n) - where n is the length of the array.
// Space Complexity: O(min(n, k)) - as we are using a hash map to store remainders.

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Initialize with 0 remainder at index -1
        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int remainder = cumulativeSum % k;

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}
