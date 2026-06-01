// Problem: Majority Element
// Platform: LeetCode
// Link: https://leetcode.com/problems/majority-element/
// Difficulty: Easy

// Approach:
// We can use the Boyer-Moore Voting Algorithm to find the majority element in linear time and constant space.
// The algorithm maintains a candidate and a count. It iterates through the array:
// - If the count is 0, it sets the current element as the candidate and resets the count to 1.
// - If the current element is the same as the candidate, it increments the count.
// - Otherwise, it decrements the count.
// After the loop, the candidate will be the majority element.

// Time Complexity: O(n) - we traverse the array once.
// Space Complexity: O(1) - we use only a constant amount of space.

class Solution {
  public int majorityElement(int[] nums) {
    int candidate = 0;
    int count = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
        count = 1;
      } else if (num == candidate) {
        count++;
      } else {
        count--;
      }
    }

    return candidate;
  }
}