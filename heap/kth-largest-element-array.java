// Problem: Kth Largest Element in an Array
// Platform: LeetCode
// Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Difficulty: Medium

// Approach:
// Use a min heap (priority queue) to keep track of the k largest elements seen so far.
// Iterate through the array, add elements to the heap, and remove the smallest whenever size exceeds k.
// The root of the min heap (peek) will be the kth largest element.
//
// Time Complexity: O(n log k) due to heap operations for n elements
// Space Complexity: O(k) for the heap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int num : nums) {
            minheap.offer(num);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        return minheap.peek();
    }
}