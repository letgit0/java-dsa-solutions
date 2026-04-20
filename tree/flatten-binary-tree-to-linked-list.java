// Problem: Flatten Binary Tree to Linked List
// Platform: LeetCode
// Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Difficulty: Medium

// Approach:
// Use an iterative approach (similar to Morris Traversal) to flatten the tree in-place.
// At each node:
// - If a left child exists:
//   - Find the rightmost node of the left subtree (predecessor).
//   - Connect it to the current node's right subtree.
//   - Move the left subtree to the right.
//   - Set the left pointer to null.
// - Move to the next node (curr.right).

// Time Complexity: O(n) - each node is visited at most twice.
// Space Complexity: O(1) - in-place transformation.

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

  public void flatten(TreeNode root) {
    TreeNode curr = root;

    while (curr != null) {
      if (curr.left != null) {
        TreeNode predecessor = curr.left;

        while (predecessor.right != null) {
          predecessor = predecessor.right;
        }

        predecessor.right = curr.right;
        curr.right = curr.left;
        curr.left = null;
      }

      curr = curr.right;
    }
  }
}