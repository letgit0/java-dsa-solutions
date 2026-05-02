// Problem: Longest Palindromic Subsequence
// Platform: LeetCode
// Link: https://leetcode.com/problems/longest-palindrome-subseq/
// Difficulty: Medium

// -------------------------------------------------------------

// Approach 1: Top-Down DP (Memoization)
// helper(i, j) returns the length of the longest palindromic subsequence
// in substring s[i...j].
//
// Transition:
// If s[i] == s[j]:
//   2 + helper(i + 1, j - 1)
// Else:
//   max(helper(i + 1, j), helper(i, j - 1))
//
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] memo = new int[n][n];
    return helper(s, 0, n - 1, memo);
  }

  private int helper(String s, int i, int j, int[][] memo) {
    if (i == j) return 1;
    if (i > j) return 0;

    if (memo[i][j] != 0) return memo[i][j];

    if (s.charAt(i) == s.charAt(j)) {
      memo[i][j] = 2 + helper(s, i + 1, j - 1, memo);
    } else {
      memo[i][j] = Math.max(
        helper(s, i + 1, j, memo),
        helper(s, i, j - 1, memo)
      );
    }

    return memo[i][j];
  }
}

// -------------------------------------------------------------

// Approach 2: LCS-Based (Space Optimized)
// The longest palindromic subsequence is equivalent to the
// longest common subsequence (LCS) between the string and its reverse.
//
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class SolutionOptimized {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    String r = new StringBuilder(s).reverse().toString();

    int[] dp = new int[n + 1];
    int[] prev = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == r.charAt(j - 1)) {
          dp[j] = 1 + prev[j - 1];
        } else {
          dp[j] = Math.max(dp[j - 1], prev[j]);
        }
      }

      // Swap arrays instead of copying
      int[] temp = prev;
      prev = dp;
      dp = temp;

      // Reset current row
      java.util.Arrays.fill(dp, 0);
    }

    return prev[n];
  }
}