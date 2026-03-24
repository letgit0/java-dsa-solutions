// Problem: Subarray Sum Equals K
// Platform: Leetcode
// Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Difficulty: Medium

// Approach:
// We use the concept of Prefix Sum along with a HashMap.
// - Maintain a running sum (prefix sum) while iterating through the array.
// - For each index, check if (currentSum - k) exists in the map.
//   If it exists, it means there is a subarray ending at current index whose sum is k.
// - The map stores frequency of prefix sums encountered so far.
// - Initialize map with (0 → 1) to handle subarrays starting from index 0.

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;

class subarray {
    public int subarraySum(int[] nums, int k) {
        int count = 0;      // Stores the number of valid subarrays
        int prefixSum = 0;  // Running sum
        
        Map<Integer, Integer> prefixMap = new HashMap<>();
        
        // Base case: prefix sum = 0 occurs once
        prefixMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if there exists a prefix sum such that:
            // currentSum - previousSum = k  => previousSum = currentSum - k
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            // Store/update current prefix sum frequency
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}