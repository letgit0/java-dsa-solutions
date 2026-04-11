// Problem: Letter Combinations of a Phone Number
// Platform: LeetCode
// Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Difficulty: Medium

// Approach:
// 1. Create a mapping of digits (2–9) to their corresponding letters.
// 2. Use backtracking to generate all possible combinations.
// 3. Start from index 0 and build the string using a StringBuilder.
// 4. For each digit, iterate over its mapped characters and recurse.
// 5. When the current combination length equals input length, add it to result.
// 6. Backtrack by removing the last character and explore other possibilities.

// Time Complexity: O(4^n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) return result;

    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    find(digits, 0, result, new StringBuilder(), map);
    return result;
  }

  private void find(String digits, int idx, List<String> res, StringBuilder sb, Map<Character, String> map) {

    if (sb.length() == digits.length()) {
      res.add(sb.toString());
      return;
    }

    for (char c : map.get(digits.charAt(idx)).toCharArray()) {
      sb.append(c);
      find(digits, idx + 1, res, sb, map);
      sb.deleteCharAt(sb.length() - 1); // backtrack
    }
  }
}