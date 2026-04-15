// Problem: Generate Parentheses
// Platform: LeetCode
// Link: https://leetcode.com/problems/generate-parentheses/
// Difficulty: Medium

// Approach:
// 1. Use backtracking to build all valid parentheses combinations.
// 2. Keep track of the number of open and close parentheses used.
// 3. Add '(' if open < n.
// 4. Add ')' if close < open to maintain validity.
// 5. When the string length reaches 2 * n, add it to the result.

// Time Complexity: O(4^n / sqrt(n))  (Catalan number growth)
// Space Complexity: O(n) (recursion stack)

import java.util.*;

class Solution {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(n, result, new StringBuilder(), 0, 0);
    return result;
  }

  private void backtrack(int n, List<String> res, StringBuilder sb, int open, int close) {
    // Base case: valid combination of length 2 * n
    if (sb.length() == 2 * n) {
      res.add(sb.toString());
      return;
    }

    // Try adding '('
    if (open < n) {
      sb.append('(');
      backtrack(n, res, sb, open + 1, close);
      sb.deleteCharAt(sb.length() - 1); // backtrack
    }

    // Try adding ')'
    if (close < open) {
      sb.append(')');
      backtrack(n, res, sb, open, close + 1);
      sb.deleteCharAt(sb.length() - 1); // backtrack
    }
  }
}