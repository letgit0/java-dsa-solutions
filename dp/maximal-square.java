// Problem: Maximal Square
// Platform: LeetCode
// Link: https://leetcode.com/problems/maximal-square/
// Difficulty: Medium

// Approach: Dynamic Programming
//The catch here is that for a cell (i, j) to be botttom corner for a sqaure of length n lets say 3, cells [i-1, j], [i-1, j-1], [i, j-1], all three shoule be bottom right of a square of length n-1 e.g. of length 2.

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

class Solution {
  public int maximalSquare(char[][] matrix) {
    // Edge case: empty or null matrix
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    // DP table with extra padding to simplify boundary checks
    int[][] dp = new int[rows + 1][cols + 1];
    int maxSide = 0;

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        // Map dp index to matrix index (offset by 1)
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = 1 + Math.min(
            dp[i - 1][j - 1],
            Math.min(dp[i - 1][j], dp[i][j - 1])
          );

          maxSide = Math.max(maxSide, dp[i][j]);
        }
      }
    }

    // Area = side^2
    return maxSide * maxSide;
  }
}