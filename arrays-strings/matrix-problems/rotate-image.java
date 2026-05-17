// Problem: Rotate Image
// Platform: LeetCode
// Link: https://leetcode.com/problems/rotate-image/
// Difficulty: Medium

// Approach:
// To rotate the image by 90 degrees clockwise, we can follow these steps:
// 1. Transpose the matrix (swap rows with columns).
// 2. Reverse each row to get the final rotated image.

// Time Complexity: O(n^2) - where n is the size of the matrix.
// Space Complexity: O(1) - in-place rotation.

class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    // Transpose the matrix
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // Reverse each row
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }
  }
}