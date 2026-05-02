// Problem: Longest Palindromic Substring
// Platform: LeetCode
// Link: https://leetcode.com/problems/longest-palindromic-substring/
// Difficulty: Medium

// -------------------------------------------------------------

// Approach 1: Dynamic Programming (2D)
// dp[i][j] = true if substring s[i...j] is a palindrome.
//
// Transition:
// s[i] == s[j] AND dp[i + 1][j - 1] is true
//
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";

    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    int start = 0;
    int maxLength = 1;

    // Base Case 1: Single characters
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    // Base Case 2: Length = 2
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }

    // Length >= 3
    for (int len = 3; len <= n; len++) {
      for (int i = 0; i <= n - len; i++) {
        int j = i + len - 1;

        if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
          dp[i][j] = true;

          if (len > maxLength) {
            start = i;
            maxLength = len;
          }
        }
      }
    }

    return s.substring(start, start + maxLength);
  }
}

// -------------------------------------------------------------

// Approach 2: Expand Around Center
// For each index, expand for:
//   1. Odd-length palindrome (i, i)
//   2. Even-length palindrome (i, i + 1)
//
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class SolutionOptimized {
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";

    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
      int len1 = expand(s, i, i);       // odd length
      int len2 = expand(s, i, i + 1);   // even length
      int len = Math.max(len1, len2);

      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private int expand(String s, int left, int right) {
    while (
      left >= 0 &&
      right < s.length() &&
      s.charAt(left) == s.charAt(right)
    ) {
      left--;
      right++;
    }

    // length of palindrome
    return right - left - 1;
  }
}