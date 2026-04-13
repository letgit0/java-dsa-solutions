// Problem: Subsets II
// Platform: LeetCode
// Link: https://leetcode.com/problems/subsets-ii/
// Difficulty: Medium

// Approach:
// 1. Similar to the Subsets problem, we use backtracking to explore all possible subsets.
// 2. To handle duplicates, we first sort the input array so that duplicate elements are adjacent.
// 3. During recursion, we skip duplicates at the same level using the condition (i > idx && nums[i] == nums[i - 1]).
// 4. This ensures that duplicate subsets are not generated.

// Time Complexity: O(2^n), where n is the number of elements in the input array.
// Space Complexity: O(k), where k is the maximum depth of the recursion (length of the largest subset).

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    generate(nums, new ArrayList<>(), result, 0);
    return result;
  }

  private void generate(int[] nums, List<Integer> curr, List<List<Integer>> result, int idx) {
    result.add(new ArrayList<>(curr));

    for (int i = idx; i < nums.length; i++) {
      if (i > idx && nums[i] == nums[i - 1]) continue;

      curr.add(nums[i]);
      generate(nums, curr, result, i + 1);
      curr.remove(curr.size() - 1);
    }
  }
}