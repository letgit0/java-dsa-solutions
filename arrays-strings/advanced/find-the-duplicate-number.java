// Problem: Find the Duplicate Number
// Platform: LeetCode
// Link: https://leetcode.com/problems/find-the-duplicate-number/
// Difficulty: Medium

// Approach:
// Use Floyd's Cycle Detection Algorithm (Tortoise and Hare).
// 1. Initialize two pointers, slow and fast, both pointing to the first element.
// 2. Move slow one step at a time and fast two steps at a time until they meet.
// 3. Once they meet, reset one pointer to the first element and move both pointers one step at a time until they meet again.
// 4. The meeting point is the duplicate number.

// Time Complexity: O(n) - we traverse the array a couple of times.
// Space Complexity: O(1) - we are using only a constant amount of extra space.

class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Initialize pointers and find intersection
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];        // moves 1 step
            hare = nums[nums[hare]];         // moves 2 steps
        } while (tortoise != hare);
        
        // Step 2: Find the entrance to the cycle
        hare = nums[0]; // reset hare to start
        while (tortoise != hare) {
            tortoise = nums[tortoise];        // moves 1 step
            hare = nums[hare];               // moves 1 step
        }
        
        return tortoise; // or hare, since they are equal
    }
}