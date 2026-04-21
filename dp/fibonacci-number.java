// Problem: Fibonacci Number
// Platform: LeetCode
// Link: https://leetcode.com/problems/fibonacci-number/
// Difficulty: Easy

// Approach: Iterative (Bottom-Up)

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int fib(int n) {
    // Base cases
    if (n <= 1) return n;

    int first = 0;
    int second = 1;

    // Compute Fibonacci iteratively
    for (int i = 2; i < n; i++) {
      int sum = first + second;
      first = second;
      second = sum;
    }

    return first + second;
  }
}