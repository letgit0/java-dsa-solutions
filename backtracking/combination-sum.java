// Problem: Combination Sum
// Platform: LeetCode
// Link: https://leetcode.com/problems/combination-sum/
// Difficulty: Medium

// Approach:
// 1. Use backtracking to explore all combinations of candidates.
// 2. At each step, add the current candidate to the combination and recurse.
// 3. If the current sum equals the target, add the combination to the result.
// 4. If the current sum exceeds the target, backtrack.

// Time Complexity: O(2^n) in the worst case, where n is the number of candidates.
// Space Complexity: O(k) where k is the maximum depth of the recursion (the length of the longest combination).

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();  
    func(candidates, target, 0, new ArrayList<>(), result, 0);
    return result;
  }
  private void func(int[] candidates, int target, int currSum, List<Integer> curr, List<List<Integer>> res, int idx){
    if(currSum == target){
      res.add(new ArrayList<>(curr));
      return;
    }
    if(currSum > target) return;
    for(int i = idx; i< candidates.length; i++){
      if(currSum + candidates[i] <= target){
        curr.add(candidates[i]);
        func(candidates, target, currSum + candidates[i], curr, res, i);
        curr.remove(curr.size()-1);
      }
    }
  }
}