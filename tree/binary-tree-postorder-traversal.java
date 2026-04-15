// Problem: Binary Tree Preorder Traversal
// Platform: LeetCode
// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Difficulty: Easy

// Approach:
// Perform a recursive preorder traversal of the binary tree.
// Traversal order: current node → left subtree → right subtree.

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

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  private void traverse(TreeNode node, List<Integer> result) {
    if (node == null) {
      return;
    }

    result.add(node.val);
    traverse(node.left, result);
    traverse(node.right, result);
  }
}