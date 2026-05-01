// Problem: Jump Game II
// Platform: LeetCode
// Link: https://leetcode.com/problems/jump-game-ii/
// Difficulty: Medium

// Approach: Greedy (Level-based BFS idea)
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int jump(int[] nums) {
    int jumps = 0;
    int currentEnd = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);

      // When we reach the end of current "jump range"
      if (i == currentEnd) {
        jumps++;
        currentEnd = farthest;
      }
    }

    return jumps;
  }
}