// Problem: Construct Binary Tree from Preorder and Inorder Traversal
// Platform: LeetCode
// Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Difficulty: Medium

// Approach:
// Use recursion with preorder and inorder traversals.
// - The current root is taken from preorder using a moving index.
// - Use a hashmap to quickly find the root's index in inorder.
// - Elements to the left of the index belong to the left subtree.
// - Elements to the right belong to the right subtree.
// - Recursively build left and right subtrees.


// Time Complexity: O(n) - each node is processed once.
// Space Complexity: O(n) - for hashmap and recursion stack.

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

  private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
  private int preorderIndex = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;

    for (int i = 0; i < n; i++) {
      inorderIndexMap.put(inorder[i], i);
    }

    return build(preorder, 0, n - 1);
  }

  private TreeNode build(int[] preorder, int left, int right) {
    if (left > right) {
      return null;
    }

    int rootVal = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootVal);

    int inorderIndex = inorderIndexMap.get(rootVal);

    root.left = build(preorder, left, inorderIndex - 1);
    root.right = build(preorder, inorderIndex + 1, right);

    return root;
  }
}