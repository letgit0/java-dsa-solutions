// Problem: Kth Smallest Element in a Sorted Matrix
// Platform: LeetCode
// Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// Difficulty: Medium

// Approach:
// Use a max heap (priority queue) to keep track of the k smallest elements seen so far.
// Iterate through each element of the matrix, add it to the heap, and remove the largest whenever size exceeds k.
// The root of the max heap (peek) will be the kth smallest element.
//
// Time Complexity: O(n*m * log k), where n*m is the number of elements in the matrix
// Space Complexity: O(k) for the heap

import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] arr : matrix) {
            for (int num : arr) {
                maxheap.offer(num);
                if (maxheap.size() > k) {
                    maxheap.poll();
                }
            }
        }

        return maxheap.peek();
    }
}