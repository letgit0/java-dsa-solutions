// Problem: Trapping Rain Water
// Platform: Leetcode
// Link: https://leetcode.com/problems/trapping-rain-water/
// Difficulty: Hard

// Approach:
// Use two pointers, one at the beginning and one at the end of the array.
// Calculate the amount of water that can be trapped at each pointer based on the maximum height to the left and right of the pointer.
// Move the pointer with the smaller height towards the other pointer, as the amount of water trapped is limited by the shorter line.

// Time Complexity: O(n) - for iterating through the array once.
// Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Work from the left side because it's the limiting factor
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // New boundary
                } else {
                    totalWater += leftMax - height[left]; // Trap water
                }
                left++;
            } else {
                // Work from the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // New boundary
                } else {
                    totalWater += rightMax - height[right]; // Trap water
                }
                right--;
            }
        }
        return totalWater;
    }
}