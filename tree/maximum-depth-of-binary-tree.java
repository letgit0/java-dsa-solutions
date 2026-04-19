// Problem: Maximum Depth of Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Difficulty: Easy

// Approach:
// Use recursion to compute the depth of the tree.
// At each node:
// - Recursively find the depth of left and right subtrees.
// - Return the maximum of the two depths plus one.


// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(h) - where h is the height of the tree (O(n) in worst case).

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

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }
}