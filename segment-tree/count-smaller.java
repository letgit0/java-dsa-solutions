// Problem: Count Of Smaller Numbers After Self
// Platform: Leetcode
// Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// Difficulty: Hard

// Approach:
// Uses coordinate compression + segment tree to count how many smaller elements exist to the right of each element in O(n log n) time.

// Time Complexity: O(n log n) (sorting + n queries/updates)
// Space Complexity: O(n) (tree + compression + result)

import java.util.*;

class Solution {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        // Step 1: Coordinate Compression
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        Map<Integer, Integer> compress = new HashMap<>();
        int index = 0;
        for (int num : sorted) {
            if (!compress.containsKey(num)) {
                compress.put(num, index++);
            }
        }

        // Replace nums with compressed values
        for (int i = 0; i < n; i++) {
            nums[i] = compress.get(nums[i]);
        }

        int maxVal = index - 1;

        // Segment Tree for frequency
        int[] segTree = new int[4 * n];

        List<Integer> result = new ArrayList<>();

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];

            // Count of numbers smaller than current
            int count = (val > 0)
                    ? query(segTree, 0, 0, maxVal, 0, val - 1)
                    : 0;

            result.add(count);

            // Mark current value as seen
            update(segTree, 0, 0, maxVal, val);
        }

        // Reverse to match original order
        Collections.reverse(result);
        return result;
    }

    // Point update: increment frequency of a value
    private void update(int[] tree, int node, int left, int right, int val) {
        if (left == right) {
            tree[node]++;
            return;
        }

        int mid = left + (right - left) / 2;

        if (val <= mid) {
            update(tree, 2 * node + 1, left, mid, val);
        } else {
            update(tree, 2 * node + 2, mid + 1, right, val);
        }

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Range query: sum in [qs, qe]
    private int query(int[] tree, int node, int left, int right, int qs, int qe) {
        if (qs > right || qe < left) return 0;

        if (qs <= left && right <= qe) return tree[node];

        int mid = left + (right - left) / 2;

        return query(tree, 2 * node + 1, left, mid, qs, qe)
             + query(tree, 2 * node + 2, mid + 1, right, qs, qe);
    }
}