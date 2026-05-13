// Problem: Find Pivot Index
// Platform: LeetCode
// Link: https://leetcode.com/problems/find-pivot-index/
// Difficulty: Easy

/*
Approach:
1. Calculate the total sum of all elements in the array.
2. Traverse the array while maintaining a running sum of elements on the left.
3. For each index:
   - Compute the right sum using:
     rightSum = totalSum - leftSum - currentElement
   - If leftSum equals rightSum, the current index is the pivot index.
4. Return the pivot index if found.
5. If no pivot index exists, return -1.

Time Complexity: O(n)
- One pass to calculate total sum.
- One pass to find the pivot index.

Space Complexity: O(1)
- Uses only constant extra space.
*/

class Solution {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Traverse the array to find pivot index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            // Check if current index is the pivot
            if (leftSum == rightSum) {
                return i;
            }

            // Update left sum for next iteration
            leftSum += nums[i];
        }

        // No pivot index found
        return -1;
    }
}