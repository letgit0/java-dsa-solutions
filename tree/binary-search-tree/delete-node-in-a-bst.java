// Problem: Delete Node in a BST
// Platform: LeetCode
// Link: https://leetcode.com/problems/delete-node-in-a-bst/
// Difficulty: Medium

// Approach:
// Use recursion to locate and delete the node with the given key.
// At each node:
// - If key is smaller, recurse into the left subtree.
// - If key is larger, recurse into the right subtree.
// - If key matches:
//   - If the node has no left child, return its right child.
//   - If the node has no right child, return its left child.
//   - If the node has two children:
//     - Find the inorder successor (smallest in right subtree).
//     - Replace current node's value with successor's value.
//     - Delete the successor from the right subtree.


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

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      // Node to delete found
      if (root.left == null) {
        return root.right;
      }

      if (root.right == null) {
        return root.left;
      }

      TreeNode successor = findMin(root.right);
      root.val = successor.val;
      root.right = deleteNode(root.right, successor.val);
    }

    return root;
  }

  private TreeNode findMin(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}