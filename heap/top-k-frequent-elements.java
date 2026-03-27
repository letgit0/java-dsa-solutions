// Problem: Top K Frequent Elements
// Platform: LeetCode
// Link: https://leetcode.com/problems/top-k-frequent-elements/
// Difficulty: Medium

// Approach:
// 1. Count the frequency of each element using a HashMap.
// 2. Use a min heap (priority queue) to keep track of the top k frequent elements.
// 3. Iterate through the map entries, add them to the heap, and remove the smallest frequency when size exceeds k.
// 4. The heap will contain the k most frequent elements.
//
// Time Complexity: O(n log k), where n is the number of unique elements
// Space Complexity: O(n) for the map and heap

import java.util.*;

class Solution {
    static class Pair {
        int elem;
        int freq;
        Pair(int e, int f) {
            elem = e;
            freq = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap to track top k frequent elements
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minheap.offer(new Pair(entry.getKey(), entry.getValue()));
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        // Extract results from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minheap.poll().elem;
        }

        return result;
    }
}