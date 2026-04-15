// Problem: Binary Tree Preorder Traversal
// Platform: Leetcode
// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Difficulty: Easy

// Approach:
// We can use a recursive approach to perform a preorder traversal of the binary tree.
// The preorder traversal visits the current node, then the left subtree, and finally the right subtree.

// Time Complexity: O(n) - where n is the number of nodes in the binary tree.
// Space Complexity: O(n) - due to the recursive call stack in the worst case (when the tree is skewed).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    private void preorder(TreeNode node, List<Integer> res){
        if(node != null){
            res.add(node.val);
            preorder(node.left, res);
            preorder(node.right, res);
        }
    }
}