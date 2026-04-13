// Problem: Palindrome Partitioning
// Platform: LeetCode
// Link: https://leetcode.com/problems/palindrome-partitioning/
// Difficulty: Medium

// Approach:
// 1. Use backtracking to explore all possible partitions of the input string.
// 2. For each partition, check if the current substring is a palindrome.
// 3. If it is a palindrome, add it to the current partition and recurse for the remaining string.
// 4. When the end of the string is reached, add the current partition to the result list.

// Time Complexity: O(2^n), where n is the length of the input string.
// Each partition requires a palindrome check, which takes O(n) in the worst case.
// Space Complexity: O(k), where k is the maximum depth of recursion (length of the largest partition).

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    combos(s, new ArrayList<>(), result, 0);
    return result;
  }

  private void combos(String s, List<String> curr, List<List<String>> res, int idx) {
    if (idx == s.length()) {
      res.add(new ArrayList<>(curr));
      return;
    }

    for (int i = idx; i < s.length(); i++) {
      if (isPalindrome(s, idx, i)) {
        curr.add(s.substring(idx, i + 1));
        combos(s, curr, res, i + 1);
        curr.remove(curr.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }
}