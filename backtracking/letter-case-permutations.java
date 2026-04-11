// Problem: Letter Case Permutation
// Platform: LeetCode
// Link: https://leetcode.com/problems/letter-case-permutation/
// Difficulty: Medium

// Approach:
// 1. Use backtracking to generate all permutations of letter cases.
// 2. Convert the string to lowercase to standardize processing.
// 3. Traverse the string character by character.
// 4. If the character is a digit, add it directly and move forward.
// 5. If it's a letter, explore both lowercase and uppercase branches.
// 6. Backtrack after each recursive call.

// Time Complexity: O(n * 2^m)
// where n = length of string, m = number of letters
// Space Complexity: O(n)

import java.util.*;

class Solution {
  public List<String> letterCasePermutation(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s.toLowerCase(), 0, new StringBuilder(), result);
    return result;
  }

  private void backtrack(String s, int idx, StringBuilder sb, List<String> res) {

    if (idx == s.length()) {
    res.add(sb.toString());
    return;
    }

    char ch = s.charAt(idx);

    if (Character.isDigit(ch)) {
      sb.append(ch);
      backtrack(s, idx + 1, sb, res);
      sb.deleteCharAt(sb.length() - 1); // backtrack
    } else {
      // lowercase branch
      sb.append(ch);
      backtrack(s, idx + 1, sb, res);
      sb.deleteCharAt(sb.length() - 1);

      // uppercase branch
      sb.append(Character.toUpperCase(ch));
      backtrack(s, idx + 1, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}