// Problem: Search in a Binary Search Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
// Difficulty: Easy

// Approach:
// Use recursion to traverse the BST based on value comparison.
// At each node:
// - If the node is null, return null.
// - If node.val equals the target, return the node.
// - If target is smaller, search in the left subtree.
// - Otherwise, search in the right subtree.


// Time Complexity: O(h) - where h is the height of the tree (O(log n) for balanced, O(n) worst case).
// Space Complexity: O(h) - due to recursion stack.

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

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (root.val == val) {
      return root;
    }

    if (val < root.val) {
      return searchBST(root.left, val);
    }

    return searchBST(root.right, val);
  }
}