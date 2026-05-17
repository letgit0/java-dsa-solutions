 // Problem: Set Matrix Zeroes
// Platform: Leetcode
// Link: https://leetcode.com/problems/set-matrix-zeroes/
// Difficulty: Medium

// Approach:
//Check the Firsts: Use two boolean variables to track if the first row and first column should eventually be zeroed out.
// Use the Matrix as a Map: Iterate through the rest of the matrix (starting at index [1][1]). If matrix[i][j] == 0, set matrix[i][0] = 0 and matrix[0][j] = 0.
// Zero Out Based on Markers: Iterate through the matrix again (skipping the first row/column) and update cells based on the markers in the first row/column.
//Handle the Firsts: Finally, use those two boolean variables from step 1 to zero out the first row and first column if necessary.

// Time Complexity: O(m*n) - where m is the number of rows and n is the number of columns, as we need to traverse the entire matrix.
// Space Complexity: O(1)

public void setZeroes(int[][] matrix) {
    boolean firstRowZero = false;
    boolean firstColZero = false;

    // Check if the first row has any zeros
    for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0) {
            firstRowZero = true;
            break;
        }
    }

    // Check if the first column has any zeros
    for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][0] == 0) {
            firstColZero = true;
            break;
        }
    }

    // Use the rest of the matrix to mark zeros in the first row and column
    for (int i = 1; i < matrix.length; i++) {
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // Zero out cells based on markers in the first row and column
    for (int i = 1; i < matrix.length; i++) {
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Zero out the first row if needed
    if (firstRowZero) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }

    // Zero out the first column if needed
    if (firstColZero) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
}   