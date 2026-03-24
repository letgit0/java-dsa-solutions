// Problem: Range Sum Query - Immutable
// Platform: Leetcode
// Link: https://leetcode.com/problems/range-sum-query-immutable/
// Difficulty: Easy

// Time Complexity: 
//   - buildTree: O(n)
//   - query: O(log n) per query
// Space Complexity: O(n)  (original array size n, segment tree ~4n)

class NumArray {
    // Segment tree array (stores sums of segments)
    private static int[] segTree;
    private int n; // Size of original array

    // Constructor: builds segment tree from input array
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[n * 4];  // Safe size for segment tree
        buildTree(nums, 0, 0, n - 1);
    }

    // Returns the sum of elements in the range [left, right]
    public int sumRange(int left, int right) {
        return query(0, left, right, 0, n - 1);
    }

    // Helper: Builds segment tree recursively
    private static void buildTree(int[] arr, int node, int left, int right) {
        if (left == right) {
            segTree[node] = arr[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(arr, 2 * node + 1, left, mid);
        buildTree(arr, 2 * node + 2, mid + 1, right);
        segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
    }

    // Helper: Queries segment tree recursively for sum in [qs, qe]
    private static int query(int node, int qs, int qe, int left, int right) {
        // No overlap
        if (right < qs || left > qe) return 0;

        // Complete overlap
        if (left >= qs && right <= qe) return segTree[node];

        // Partial overlap
        int mid = left + (right - left) / 2;
        int leftSum = query(2 * node + 1, qs, qe, left, mid);
        int rightSum = query(2 * node + 2, qs, qe, mid + 1, right);
        return leftSum + rightSum;
    }
}

/**
 * Example usage:
 * NumArray obj = new NumArray(nums);
 * int sum = obj.sumRange(left, right);
 */