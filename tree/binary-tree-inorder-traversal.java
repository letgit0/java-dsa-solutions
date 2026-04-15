// Problem: Binary Tree Inorder Traversal
// Platform: LeetCode
// Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Difficulty: Easy

// Approach:
// Use recursion to perform an inorder traversal of the binary tree.
// Inorder traversal order: left subtree → current node → right subtree.

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

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }

  private void inorder(TreeNode node, List<Integer> result) {
    if (node == null) {
      return;
    }

    inorder(node.left, result);
    result.add(node.val);
    inorder(node.right, result);
  }
}