// Problem: Edit Distance
// Platform: LeetCode
// Link: https://leetcode.com/problems/edit-distance/
// Difficulty: Medium

// Approach:
// Use dynamic programming.
// Let dp[i][j] represent the minimum number of operations required
// to convert the first i characters of word1 into the first j characters of word2.
//
// We use a (n + 1) x (m + 1) DP table to handle base cases involving empty strings.
//
// Transition:
// If characters match → no operation needed:
//   dp[i][j] = dp[i - 1][j - 1]
// Else → take the minimum of:
//   1. Replace: dp[i - 1][j - 1]
//   2. Delete:  dp[i - 1][j]
//   3. Insert:  dp[i][j - 1]
// Add 1 operation to the chosen minimum.
//
// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
// (Can be optimized to O(m) using a rolling array.)

class Solution {
  public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    int[][] dp = new int[n + 1][m + 1];

    // Base case: converting empty word1 to word2
    for (int j = 0; j <= m; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= n; i++) {
      // Base case: converting word1 to empty word2
      dp[i][0] = i;

      for (int j = 1; j <= m; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(
            dp[i - 1][j - 1], // replace
            Math.min(
              dp[i - 1][j],   // delete
              dp[i][j - 1]    // insert
            )
          );
        }
      }
    }

    return dp[n][m];
  }
}