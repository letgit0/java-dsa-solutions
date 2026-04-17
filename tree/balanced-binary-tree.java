// Problem: Balanced Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/balanced-binary-tree/description/
// Difficulty: Easy

// Approach:
// Use a bottom-up DFS to compute subtree heights.
// If any subtree is unbalanced, propagate -1 upward as a signal.
// Otherwise, return the height of the current node.

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

  public boolean isBalanced(TreeNode root) {
    return getHeightIfBalanced(root) != -1;
  }

  private int getHeightIfBalanced(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = getHeightIfBalanced(root.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = getHeightIfBalanced(root.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}