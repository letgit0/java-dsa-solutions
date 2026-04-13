// Problem: N-Queens II
// Platform: LeetCode
// Link: https://leetcode.com/problems/n-queens-ii/
// Difficulty: Hard

// Approach:
// 1. Use backtracking to explore all possible ways to place n queens on an n x n board.
// 2. Place one queen per row and proceed row by row.
// 3. For each row, try placing a queen in every column and check if it is safe.
// 4. A position is safe if no queen exists in the same column or along both diagonals.
// 5. If valid, place the queen and recursively move to the next row.
// 6. When all queens are placed (row == n), count it as one valid configuration.
// 7. Backtrack by removing the queen and continue exploring other possibilities.

// Time Complexity: O(n!), as we try placing queens row by row with pruning.
// In practice, the number of valid states is much smaller due to constraints.

// Space Complexity: O(n) auxiliary space for recursion stack.
// The board uses O(n^2) space, but it is reused (not counted as extra per recursion).

class Solution {
  public int totalNQueens(int n) {
    char[][] board = new char[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], '.');
    }

    return backtrack(n, board, 0);
  }

  private int backtrack(int n, char[][] board, int row) {
    if (row == n) return 1;

    int cnt = 0;

    for (int col = 0; col < n; col++) {
      if (isSafe(n, board, row, col)) {
        board[row][col] = 'Q';
        cnt += backtrack(n, board, row + 1);
        board[row][col] = '.';
      }
    }

    return cnt;
  }

  private boolean isSafe(int n, char[][] board, int r, int c) {
    for (int i = 0; i < r; i++) {
      // Check same column
      if (board[i][c] == 'Q') return false;

      // Check right diagonal
      if (c + (r - i) < n && board[i][c + (r - i)] == 'Q') return false;

      // Check left diagonal
      if (c - (r - i) >= 0 && board[i][c - (r - i)] == 'Q') return false;
    }

    return true;
  }
}