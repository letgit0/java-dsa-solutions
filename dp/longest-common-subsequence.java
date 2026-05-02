// Problem: Longest Common Subsequence
// Platform: LeetCode
// Link: https://leetcode.com/problems/longest-common-subsequence/
// Difficulty: Medium

// Approach 1: Tabulation (2D DP)
// dp[i][j] represents the length of the longest common subsequence
// between the first i characters of text1 and the first j characters of text2.
//
// Transition:
// If characters match:
//   dp[i][j] = 1 + dp[i - 1][j - 1]
// Else:
//   dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
//
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }
}

// -------------------------------------------------------------

// Approach 2: Space Optimization (1D DP)
// We only need the previous row at any time, so we use two arrays:
//   - prev[] → previous row
//   - dp[]   → current row
//
// Time Complexity: O(m * n)
// Space Complexity: O(n)

class SolutionOptimized {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[] dp = new int[n + 1];
    int[] prev = new int[n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[j] = 1 + prev[j - 1];
        } else {
          dp[j] = Math.max(prev[j], dp[j - 1]);
        }
      }

      // Copy current row to previous row
      for (int j = 0; j <= n; j++) {
        prev[j] = dp[j];
      }
    }

    return dp[n];
  }
}