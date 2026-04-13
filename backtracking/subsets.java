 // Problem: Subsets
// Platform: LeetCode
// Link: https://leetcode.com/problems/subsets/
// Difficulty: Medium

// Approach:
// 1. Use backtracking to explore all possible subsets of the given array.
// 2. Start with an empty subset, and at each step, include the current element and recurse further.
// 3. After exploring with the current element, backtrack by removing it and explore subsets without it.
// 4. At every recursive call, add the current subset to the result.

// Time Complexity: O(2^n), where n is the number of elements in the input array.
// Space Complexity: O(k), where k is the maximum depth of the recursion (length of the largest subset).

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allsubsets = new ArrayList<>();
    generate(nums, new ArrayList<>(), allsubsets, 0);
    return allsubsets;
  }

  private void generate(int[] nums, List<Integer> curr, List<List<Integer>> result, int idx) {
    result.add(new ArrayList<>(curr));

    for (int i = idx; i < nums.length; i++) {
      curr.add(nums[i]);
      generate(nums, curr, result, i + 1);
      curr.remove(curr.size() - 1);
    }
  }
}