// Problem: Spiral Matrix
// Platform: LeetCode
// Link: https://leetcode.com/problems/spiral-matrix/
// Difficulty: Medium

// Approach:
// Use four pointers (top, bottom, left, right) to define the current boundaries of the matrix.
// Traverse the matrix in a spiral manner:
// 1. Traverse from left to right along the top row, then move the top pointer down.
// 2. Traverse from top to bottom along the right column, then move the right pointer left.
// 3. Traverse from right to left along the bottom row, then move the bottom pointer up.
// 4. Traverse from bottom to top along the left column, then move the left pointer right.
// Continue this process until the pointers cross each other, indicating that all elements have been traversed.

// Time Complexity: O(n * m) - where n is the number of rows and m is the number of columns in the matrix.
// Space Complexity: O(1) - excluding the space required for the output list.

class Solution {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      // Traverse from left to right along the top row
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      top++;

      // Traverse from top to bottom along the right column
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      right--;

      if (top <= bottom) {
        // Traverse from right to left along the bottom row
        for (int i = right; i >= left; i--) {
          result.add(matrix[bottom][i]);
        }
        bottom--;
      }

      if (left <= right) {
        // Traverse from bottom to top along the left column
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }

    return result;
  }
}