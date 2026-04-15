// Problem: Same Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/same-tree/
// Difficulty: Easy

// Approach:
// Use recursion to compare both trees node by node.
// - If both nodes are null → trees are identical at this branch.
// - If one is null and the other is not → trees are different.
// - If values differ → trees are different.
// - Otherwise, recursively compare left and right subtrees.

// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(n) - due to recursive call stack in the worst case (skewed tree).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode() {}
 *   TreeNode(int val) { this.val = val; }
 *   TreeNode(int val, TreeNode left, TreeNode right) {
 *     this.val = val;
 *     this.left = left;
 *     this.right = right;
 *   }
 * }
 */
class Solution {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) &&
           isSameTree(p.right, q.right);
  }
}