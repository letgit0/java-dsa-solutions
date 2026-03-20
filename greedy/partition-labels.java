// Problem: Partition Labels
// Platform: LeetCode
// Link: https://leetcode.com/problems/partition-labels/
// Difficulty: Medium  

// Approach:
// Precompute last occurrence of each character
// Then expand partition until current index hits the boundary

// Time Complexity: O(n) - we traverse the string twice, once to fill the last occurrence and once to find the partitions.
// Space Complexity: O(1) - since we are only storing 26 characters.

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0;i< n;i++){
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0;i < n; i++){
            end = Math.max(end, last[s.charAt(i)-'a']);
            if( i == end){
                result.add(end- start + 1);
                start = i+1;
            }
        }
        return result;
    }
}