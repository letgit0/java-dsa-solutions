// Problem: Binary Tree Maximum Path Sum
// Platform: LeetCode
// Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Difficulty: Hard

// Approach:
// Use DFS to compute the maximum path sum.
// At each node:
// - Recursively compute the maximum contribution from left and right subtrees.
// - Ignore negative contributions by taking max(0, subtree sum).
// - The path passing through the current node = left + right + node.val.
// - Update the global maximum if this path is better.
// - Return the maximum contribution to the parent (node + max(left, right)).


// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(h) - where h is the height of the tree (O(n) worst case).

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

  private int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    computeMaxPath(root);
    return maxSum;
  }

  private int computeMaxPath(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftSum = Math.max(0, computeMaxPath(node.left));
    int rightSum = Math.max(0, computeMaxPath(node.right));

    maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

    return node.val + Math.max(leftSum, rightSum);
  }
}