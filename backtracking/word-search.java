// Problem: Word Search
// Platform: LeetCode
// Link: https://leetcode.com/problems/word-search/
// Difficulty: Medium

// Approach:
// 1. Use backtracking starting from each cell in the board.
// 2. At each step, explore all four directions (up, down, left, right).
// 3. Use a visited matrix to avoid revisiting the same cell in one path.
// 4. If all characters of the word are matched, return true.
// 5. Backtrack by unmarking the current cell.

// Time Complexity: O(m * n * 4^L)
// Space Complexity: O(m * n + L)

class Solution {

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    boolean[][] visited = new boolean[rows][cols];

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (backtrack(board, word, visited, 0, r, c)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, String word, boolean[][] visited,
                            int idx, int r, int c) {

    // Boundary + visited + mismatch check
    if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
        visited[r][c] || board[r][c] != word.charAt(idx)) {
      return false;
    }

    // Last character matched
    if (idx == word.length() - 1) {
      return true;
    }

    visited[r][c] = true;

    boolean found =
        backtrack(board, word, visited, idx + 1, r + 1, c) ||
        backtrack(board, word, visited, idx + 1, r - 1, c) ||
        backtrack(board, word, visited, idx + 1, r, c + 1) ||
        backtrack(board, word, visited, idx + 1, r, c - 1);

    visited[r][c] = false; // backtrack

    return found;
  }
}