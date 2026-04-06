// Problem: Sort Characters By Frequency
// Platform: LeetCode
// Link: https://leetcode.com/problems/sort-characters-by-frequency
// Difficulty: Medium

// Approach:
// 1. Use a HashMap to store the frequency of each character in the string.
// 2. Create a max heap (PriorityQueue) that sorts characters based on frequency in descending order.
// 3. Push all (character, frequency) pairs into the max heap.
// 4. Extract elements from the heap one by one, and append the character 'frequency' times to the result string.
// 5. Return the final constructed string.

// Time Complexity: O(n + k log k)
// - O(n) to build the frequency map
// - O(k log k) to insert k unique characters into the heap and extract them

// Space Complexity: O(k)
// - O(k) for the HashMap
// - O(k) for the PriorityQueue

class Solution {
    private static class Pair {
        char ch;
        int freq;

        Pair(char c, int f) {
            ch = c;
            freq = f;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((b,a) -> a.freq - b.freq);
       for(Map.Entry<Character, Integer> entry: map.entrySet()){
        maxheap.add(new Pair(entry.getKey(), entry.getValue()));
       }
        StringBuilder sb = new StringBuilder();
        while (maxheap.size() > 0) {
            Pair p = maxheap.poll();
            int times = p.freq;
            char c =p.ch;
            while(times > 0){
                sb.append(p.ch); times--;
            }
        }
        return sb.toString();
    }
}