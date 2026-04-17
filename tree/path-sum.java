// Problem: Path Sum
// Platform: LeetCode
// Link: https://leetcode.com/problems/path-sum/
// Difficulty: Easy

// Approach:
// Use recursion to check for a root-to-leaf path that matches the target sum.
// At each node:
// - Subtract the node's value from the target sum.
// - If it's a leaf node, check if the remaining sum equals the node's value.
// - Otherwise, recursively check both left and right subtrees.


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

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    // Check if it's a leaf node
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }

    int remainingSum = targetSum - root.val;

    boolean left = hasPathSum(root.left, remainingSum);
    boolean right = hasPathSum(root.right, remainingSum);

    return left || right;
  }
}