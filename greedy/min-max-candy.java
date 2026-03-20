// Problem: Shop in Candy Store
// Platform: GeeksforGeeks
// Link: https://www.geeksforgeeks.org/shop-in-candy-store/
// Difficulty: Easy  

// Approach: We can sort the array of prices and then calculate the minimum cost by buying the cheapest candies first and the maximum cost by buying the most expensive candies first. We can use two pointers to keep track of the current position in the sorted array and the number of candies covered so far.

// Time Complexity: O(n log n) - due to sorting
// Space Complexity: O(1) - we use a fixed-size array of 26 characters to store the last occurrence of each character.

class Solution {
  public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
    int n = prices.length;
    Arrays.sort(prices);
    int minCost = 0;
    int maxCost = 0;
    int i = 0;
    int covered = n;
    while (i < covered) {
      minCost += prices[i];
      covered -= k;
      i++;
    }
    i = n - 1;
    covered = -1;
    while (i > covered) {
      maxCost += prices[i];
      covered += k;
      i--;
    }
    return new ArrayList<>(List.of(minCost, maxCost));
  }
}