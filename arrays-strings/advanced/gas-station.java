// Problem: Gas Station
// Platform: LeetCode
// Link: https://leetcode.com/problems/gas-station
// Difficulty: Medium

// Approach: 
// 1. Calculate the total gas and total cost. If total gas is less than total cost, return -1.
// 2. Otherwise, iterate through the gas stations and keep track of the current gas.
// 3. If at any point the current gas becomes negative, reset it and set the starting station to the next station.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startStation = i + 1;
            }
        }

        return totalGas < totalCost ? -1 : startStation;
    }
}