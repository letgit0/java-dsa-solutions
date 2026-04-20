// Problem: Serialize and Deserialize Binary Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Difficulty: Hard

// Approach:
// Use level-order traversal (BFS) for both serialization and deserialization.
// Serialization:
// - Traverse the tree using a queue.
// - Append node values or "null" for missing nodes.
// Deserialization:
// - Reconstruct the tree using a queue.
// - Assign left and right children sequentially using the serialized data.

// Time Complexity: O(n) - where n is the number of nodes.
// Space Complexity: O(n) - for queue and string storage.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "null";
    }

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        sb.append("null,");
        continue;
      }

      sb.append(node.val).append(",");
      queue.offer(node.left);
      queue.offer(node.right);
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }

    String[] arr = data.split(",");
    if (arr[0].equals("null")) {
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;

    while (!queue.isEmpty() && i < arr.length) {
      TreeNode node = queue.poll();

      // Left child
      if (i < arr.length && !arr[i].equals("null")) {
        node.left = new TreeNode(Integer.parseInt(arr[i]));
        queue.offer(node.left);
      }
      i++;

      // Right child
      if (i < arr.length && !arr[i].equals("null")) {
        node.right = new TreeNode(Integer.parseInt(arr[i]));
        queue.offer(node.right);
      }
      i++;
    }

    return root;
  }
}

// Usage:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));