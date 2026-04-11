// Problem: Combinations
// Platform: LeetCode
// Link: https://leetcode.com/problems/combinations/
// Difficulty: Medium

// Approach:
// 1. Use backtracking starting from number 1.
// 2. At each step, pick the next number in increasing order.
// 3. Maintain a current combination list.
// 4. When size becomes k, add it to result.
// 5. Use pruning to avoid unnecessary recursion.
//
// Time Complexity: O(C(n, k) * k)
// Space Complexity: O(k)

import java.util.*;

class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(1, n, k, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(int start, int n, int k,List<Integer> curr,List<List<Integer>> res) {

    if (curr.size() == k) {
      res.add(new ArrayList<>(curr));
      return;
    }

    // Pruning: ensure enough elements remain
    for (int i = start; i <= n - (k - curr.size()) + 1; i++) {
      curr.add(i);
      backtrack(i + 1, n, k, curr, res);
      curr.remove(curr.size() - 1); // backtrack
    }
  }
}