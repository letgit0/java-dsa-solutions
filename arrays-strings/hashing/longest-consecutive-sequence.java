// Problem: Longest Consecutive Sequence
// Platform: Leetcode
// Link: https://leetcode.com/problems/longest-consecutive-sequence/
// Difficulty: Medium

// Approach:
// 1. Use a hash set to store all the numbers in the input array for O(1) lookups.
// 2. Iterate through each number in the array. For each number, check if it's the start of a sequence (i.e., check if the number minus one is not in the set).
// 3. If it's the start of a sequence, keep checking for the next numbers in the sequence (i.e., number + 1, number + 2, etc.) and count the length of the sequence.
// 4. Keep track of the maximum length of any sequence found and return it at the end.

// Time Complexity: O(n) - where n is the number of elements in the array.
// Space Complexity: O(n) - in the worst case, all elements are stored in the hash set.

class Solution {
    public int longestConsecutive(int[] nums) {
        // Step 1: Create a hash set of all numbers for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through each number in the array
        for (int num : nums) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Step 3: Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Step 4: Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}