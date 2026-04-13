// Problem: N-Queens
// Platform: LeetCode
// Link: https://leetcode.com/problems/n-queens/
// Difficulty: Hard

// Approach:
// 1. Use backtracking to explore all possible placements of queens on the board.
// 2. Place one queen per row and move row by row.
// 3. For each row, try placing a queen in every column and check if it is safe.
// 4. A position is safe if no queen exists in the same column, or on the same diagonals.
// 5. If valid, place the queen and recursively proceed to the next row.
// 6. When all queens are placed (row == n), add the board configuration to the result.

// Time Complexity: O(n!), as we attempt to place n queens with pruning.
// Space Complexity: O(n^2), for storing the board configurations.

class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], '.');
    }

    backtrack(n, board, result, 0);
    return result;
  }

  private void backtrack(int n, char[][] board, List<List<String>> res, int r) {
    if (r == n) {
      List<String> curr = new ArrayList<>();
      for (char[] row : board) {
        curr.add(new String(row));
      }
      res.add(new ArrayList<>(curr));
      return;
    }

    for (int c = 0; c < n; c++) {
      if (isSafe(r, c, board)) {
        board[r][c] = 'Q';
        backtrack(n, board, res, r + 1);
        board[r][c] = '.';
      }
    }
  }

  private boolean isSafe(int r, int c, char[][] board) {
    int n = board.length;

    for (int i = 0; i < r; i++) {
      // Check same column
      if (board[i][c] == 'Q') return false;

      // Check left diagonal
      if (c - (r - i) >= 0 && board[i][c - (r - i)] == 'Q') return false;

      // Check right diagonal
      if (c + (r - i) < n && board[i][c + (r - i)] == 'Q') return false;
    }

    return true;
  }
}