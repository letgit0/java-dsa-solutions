// Problem: Binary Tree Level Order Traversal
// Platform: LeetCode
// Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
// Difficulty: Medium

// Approach:
// Use a queue to perform Breadth-First Search (BFS).
// At each level:
// - Process all nodes currently in the queue (level size).
// - Add their values to a list for the current level.
// - Push their children into the queue.
// - Add the level list to the final result.


// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(n) - due to the queue storing nodes level by level.

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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        currentLevel.add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      result.add(currentLevel);
    }

    return result;
  }
}