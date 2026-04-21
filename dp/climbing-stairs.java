// Problem: Climbing Stairs
// Platform: LeetCode
// Link: https://leetcode.com/problems/climbing-stairs
// Difficulty: Easy

// Approach:
// To reach step n, you can only come from:
// - Step n-1 (1-step jump)
// - Step n-2 (2-step jump)
// So, total ways = ways(n-1) + ways(n-2)

class Solution {
  public int climbStairs(int n) {
    // Base cases
    if (n < 4) return n;

    int prev2 = 2; // ways to reach step 2
    int prev1 = 3; // ways to reach step 3

    for (int i = 3; i < n; i++) {
      int curr = prev2 + prev1;
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
}