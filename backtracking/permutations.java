// Problem: Permutations
// Platform: LeetCode
// Link: https://leetcode.com/problems/permutations/
// Difficulty: Medium

// Approach:
// 1. Use backtracking to generate all permutations.
// 2. Maintain a boolean array `visited` to track used elements.
// 3. Build the current permutation using a list.
// 4. For each position, try all unused elements.
// 5. When the current permutation size equals input length, add it to result.
// 6. Backtrack by removing the last element and marking it as unused.

// Time Complexity: O(n!)
// Space Complexity: O(n)

import java.util.*;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      boolean[] visited = new boolean[nums.length];
      visited[i] = true;

      List<Integer> current = new ArrayList<>();
      current.add(nums[i]);

      perm(nums, current, result, visited);
    }

    return result;
  }

  private void perm(int[] nums, List<Integer> curr, List<List<Integer>> res, boolean[] visited) {

    if (curr.size() == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        curr.add(nums[i]);

        perm(nums, curr, res, visited);

        curr.remove(curr.size() - 1); // backtrack
        visited[i] = false;
      }
    }
  }
}