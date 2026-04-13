// Problem: Combination Sum II
// Platform: LeetCode
// Link: https://leetcode.com/problems/combination-sum-ii/
// Difficulty: Medium

// Approach:
// 1. Sort the candidates array to handle duplicates easily.
// 2. Use backtracking to explore all possible combinations of candidates.
// 3. At each step, pick the current candidate and recurse with the updated target.
// 4. If the target becomes 0, add the current combination to the result.
// 5. If the target becomes negative, stop exploring that path (handled implicitly).
// 6. Skip duplicates by ensuring the same element is not used at the same recursion level.

// Time Complexity: O(2^n) in the worst case, where n is the number of candidates.
// Space Complexity: O(k), where k is the maximum depth of the recursion (length of the longest combination).

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, target, new ArrayList<>(), result, 0);
    return result;
  }

  private void backtrack(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int idx) {
    if (target == 0) {
      res.add(new ArrayList<>(curr));
      return;
    }

    for (int i = idx; i < candidates.length; i++) {
      if (i > idx && candidates[i] == candidates[i - 1]) continue;

      if (candidates[i] <= target) {
        curr.add(candidates[i]);
        backtrack(candidates, target - candidates[i], curr, res, i + 1);
        curr.remove(curr.size() - 1);
      }
    }
  }
}