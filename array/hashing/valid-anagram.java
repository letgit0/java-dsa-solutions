// Problem: Valid Anagram
// Platform: Leetcode
// Link: https://leetcode.com/problems/valid-anagram/
// Difficulty: Easy

// Approach:
// 1. Use a frequency array (or hash map) to count the occurrences of each character in both strings.
// 2. Compare the frequency counts of both strings. If they match, the strings are anagrams of each other.

// Time Complexity: O(n) - where n is the length of the strings, as we need to traverse both strings once.
// Space Complexity: O(1) - as we are using a fixed-size frequency array for lowercase letters.

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }
}