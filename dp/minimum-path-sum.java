// Problem: Minimum Path Sum
// Platform: LeetCode
// Link: https://leetcode.com/problems/minimum-path-sum/
// Difficulty: Medium

// -------------------------------------------------------------

// Approach 1: DP with 1D Array (Space Optimized)
// dp[j] represents the minimum path sum to reach column j in the current row.
//
// Transition:
// dp[j] = grid[i][j] + min(dp[j] (top), dp[j - 1] (left))
//
// Time Complexity: O(m * n)
// Space Complexity: O(n)

class Solution {
  public int minPathSum(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;

    int[] dp = new int[c];

    // Initialize first row
    dp[0] = grid[0][0];
    for (int j = 1; j < c; j++) {
      dp[j] = dp[j - 1] + grid[0][j];
    }

    for (int i = 1; i < r; i++) {
      // First column (can only come from top)
      dp[0] += grid[i][0];

      for (int j = 1; j < c; j++) {
        dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
      }
    }

    return dp[c - 1];
  }
}

// -------------------------------------------------------------

// Approach 2: In-Place DP (Modify Input Grid)
// Reuse the grid to store the minimum path sums.
//
// Time Complexity: O(m * n)
// Space Complexity: O(1) (ignoring input modification)

class SolutionInPlace {
  public int minPathSum(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;

    // First column
    for (int i = 1; i < r; i++) {
      grid[i][0] += grid[i - 1][0];
    }

    // First row
    for (int j = 1; j < c; j++) {
      grid[0][j] += grid[0][j - 1];
    }

    // Fill rest of grid
    for (int i = 1; i < r; i++) {
      for (int j = 1; j < c; j++) {
        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
      }
    }

    return grid[r - 1][c - 1];
  }
}