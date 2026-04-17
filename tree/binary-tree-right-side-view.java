// Problem: Binary Tree Right Side View
// Platform: LeetCode
// Link: https://leetcode.com/problems/binary-tree-right-side-view/
// Difficulty: Medium

// Approach:
// Use DFS (preorder traversal) prioritizing the right subtree.
// At each node:
// - If the node is null, return.
// - If the current depth equals the result size, this is the first node at this level,
//   so add it to the result.
// - Recurse first on the right subtree, then on the left.
// This ensures the first node visited at each level is the rightmost node.


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

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, 0, result);
    return result;
  }

  private void dfs(TreeNode node, int depth, List<Integer> result) {
    if (node == null) {
      return;
    }

    if (depth == result.size()) {
      result.add(node.val);
    }

    dfs(node.right, depth + 1, result);
    dfs(node.left, depth + 1, result);
  }
}