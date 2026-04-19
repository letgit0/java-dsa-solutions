// Problem: Insert into a Binary Search Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Difficulty: Medium

// Approach:
// Use recursion to insert a value into the BST.
// At each node:
// - If the node is null, create and return a new node.
// - If val is smaller, insert into the left subtree.
// - Otherwise, insert into the right subtree.
// Return the root after insertion.


// Time Complexity: O(h) - where h is the height of the tree (O(log n) if balanced, O(n) worst case).
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

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }

    return root;
  }
}