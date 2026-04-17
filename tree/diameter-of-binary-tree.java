// Problem: Diameter of Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/diameter-of-binary-tree/
// Difficulty: Easy

// Approach:
// Use a bottom-up DFS to compute the height of each subtree.
// At every node:
// - Calculate left and right subtree heights.
// - The diameter passing through the node = leftHeight + rightHeight.
// - Update a global maximum diameter.
// - Return the height of the current node to the parent.


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

  private int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    computeHeight(root);
    return diameter;
  }

  private int computeHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = computeHeight(node.left);
    int rightHeight = computeHeight(node.right);

    diameter = Math.max(diameter, leftHeight + rightHeight);

    return Math.max(leftHeight, rightHeight) + 1;
  }
}