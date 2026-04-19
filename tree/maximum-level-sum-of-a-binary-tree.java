// Problem: Maximum Level Sum of a Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
// Difficulty: Medium

// Approach:
// Use level-order traversal (BFS) to compute the sum at each level.
// At each level:
// - Process all nodes in the queue.
// - Compute the sum of their values.
// - Track the maximum sum and corresponding level number.


// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(w) - where w is the maximum width of the tree.

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

  public int maxLevelSum(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int maxSum = Integer.MIN_VALUE;
    int level = 0;
    int answer = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      int levelSum = 0;
      level++;

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        levelSum += node.val;

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      if (levelSum > maxSum) {
        maxSum = levelSum;
        answer = level;
      }
    }

    return answer;
  }
}