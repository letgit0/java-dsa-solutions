// Problem: Triangle
// Platform: LeetCode
// Link: https://leetcode.com/problems/triangle/
// Difficulty: Medium

// -------------------------------------------------------------

// Approach 1: Top-Down DP (In-Place)
// Modify the triangle while traversing from top to bottom.
// Each cell stores the minimum path sum to reach that position.
//
// Transition:
// triangle[i][j] += min(triangle[i-1][j], triangle[i-1][j-1])
//
// Time Complexity: O(n^2)
// Space Complexity: O(1) (in-place)

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int r = triangle.size();

    for (int i = 1; i < r; i++) {
      int c = i + 1;

      // First element (only one parent)
      triangle.get(i).set(
        0,
        triangle.get(i).get(0) + triangle.get(i - 1).get(0)
      );

      // Middle elements
      for (int j = 1; j < c - 1; j++) {
        int curr = triangle.get(i).get(j);
        int val = Math.min(
          triangle.get(i - 1).get(j),
          triangle.get(i - 1).get(j - 1)
        );
        triangle.get(i).set(j, curr + val);
      }

      // Last element (only one parent)
      triangle.get(i).set(
        c - 1,
        triangle.get(i).get(c - 1) + triangle.get(i - 1).get(c - 2)
      );
    }

    // Find minimum in last row
    int lastRow = r - 1;
    int ans = triangle.get(lastRow).get(0);

    for (int val : triangle.get(lastRow)) {
      ans = Math.min(ans, val);
    }

    return ans;
  }
}

// -------------------------------------------------------------

// Approach 2: Bottom-Up DP (1D Array)
// Start from the last row and move upwards.
//
// Transition:
// dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
//
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class SolutionOptimized {
  public int minimumTotal(List<List<Integer>> triangle) {
    int r = triangle.size();
    int c = triangle.get(r - 1).size();

    int[] dp = new int[c];

    // Initialize with last row
    for (int i = 0; i < c; i++) {
      dp[i] = triangle.get(r - 1).get(i);
    }

    // Bottom-up computation
    for (int i = r - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
      }
    }

    return dp[0];
  }
}