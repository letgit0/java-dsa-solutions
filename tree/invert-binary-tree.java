// Problem: Invert Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/invert-binary-tree/
// Difficulty: Easy

// Approach:
// Use recursion to invert the binary tree.
// For each node, swap its left and right children, then recursively
// apply the same operation to both subtrees.

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

  public TreeNode invertTree(TreeNode root) {
    invert(root);
    return root;
  }

  private void invert(TreeNode node) {
    if (node == null) {
      return;
    }

    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;

    invert(node.left);
    invert(node.right);
  }
}