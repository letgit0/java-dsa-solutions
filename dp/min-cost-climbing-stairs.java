// Problem: Min Cost Climbing Stairs
// Platform: LeetCode
// Link: https://leetcode.com/problems/min-cost-climbing-stairs/
// Difficulty: Easy

// Approach: Dynamic Programming (Space Optimized)

/*You want the minimum cost to reach the “top” (beyond the last index), where:
dp[i]=min cost to reach step i
And:
dp[i]=min(dp[i−1]+cost[i−1], dp[i−2]+cost[i−2])
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;

    int prev2 = 0; // cost to reach step i-2
    int prev1 = 0; // cost to reach step i-1

    for (int i = 2; i <= n; i++) {
      int curr = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
}