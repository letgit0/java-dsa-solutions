// Problem: Container With Most Water
// Platform: Leetcode
// Link: https://leetcode.com/problems/container-with-most-water/
// Difficulty: Medium

// Approach:
// Use two pointers, one at the beginning and one at the end of the array.
// Calculate the area formed between the two pointers and update the maximum area.
// Since the area is limited by the shorter line, move the pointer pointing to the shorter line towards the other pointer.

// Time Complexity: O(n) - for iterating through the array once.
// Space Complexity: O(1) - only using a constant amount of extra space.

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length- 1;
        int maxWater = 0;
        while(i < j){
            int curr = Math.min(height[i], height[j]) * (j - i);
            maxWater = Math.max(curr, maxWater);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }
}