// Problem: Product of Array Except Self
// Platform: LeetCode
// Link: https://leetcode.com/problems/product-of-array-except-self/
// Difficulty: Medium

/*
Approach: Prefix & Suffix Product
For each index i, the required result is:
product of all elements to the left of i × product of all elements to the right of i

Algorithm:
1. Traverse from left to right:
   - Store prefix product at each index in ans[].
2. Traverse from right to left:
   - Multiply current ans[i] with suffix product.
   - Update suffix product.

Edge Cases:
- Arrays containing zero(s) are handled naturally.
Example:
nums = [0, 0, 3]
Output = [0, 0, 0]
*/

//Time Complexity: O(n)
//Space Complexity: O(1) - Excluding the output array

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: Store prefix products in ans[]
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}