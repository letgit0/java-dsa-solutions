// Problem: Validate Binary Search Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/validate-binary-search-tree/
// Difficulty: Medium

// Approach:
// Use recursion with value bounds (min, max) to validate BST properties.
// At each node:
// - Ensure node.val lies strictly between min and max.
// - For the left subtree, update max = node.val.
// - For the right subtree, update min = node.val.
// Using long bounds avoids overflow edge cases.


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

  public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validate(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.val <= min || node.val >= max) {
      return false;
    }

    return validate(node.left, min, node.val)
        && validate(node.right, node.val, max);
  }
}