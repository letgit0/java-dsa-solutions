// Problem: Lowest Common Ancestor of a Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Difficulty: Medium

// Approach:
// Use recursion to find the lowest common ancestor (LCA).
// At each node:
// - If the node is null or matches p or q, return the node.
// - Recursively search in left and right subtrees.
// - If both sides return non-null, current node is the LCA.
// - Otherwise, return the non-null result from either subtree.
// The first node that receives both p and q from its subtrees is the LCA.


// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(h) - where h is the height of the tree (O(n) in worst case).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int x) { val = x; }
 * }
 */
class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    return (left != null) ? left : right;
  }
}