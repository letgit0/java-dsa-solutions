// Problem: Jump Game
// Platform: LeetCode
// Link: https://leetcode.com/problems/jump-game/
// Difficulty: Medium

// Approach: Greedy (Track farthest reachable index)
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public boolean canJump(int[] nums) {
    int n = nums.length;

    int maxReach = 0;

    for (int i = 0; i < n; i++) {
      // If current index is not reachable, stop
      if (i > maxReach) return false;

      maxReach = Math.max(maxReach, i + nums[i]);

      // Early exit if we can reach last index
      if (maxReach >= n - 1) return true;
    }

    return true;
  }
}