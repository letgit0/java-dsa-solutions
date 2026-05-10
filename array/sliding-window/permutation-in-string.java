// Problem: Permutation in String
// Platform: Leetcode
// Link: https://leetcode.com/problems/permutation-in-string/
// Difficulty: Medium

// Approach:
// 1. Use a sliding window of size equal to the length of s1 to traverse through s2.
// 2. For each window, check if the frequency of characters in the window matches the frequency of characters in s1.
// 3. Use two frequency arrays (or hash maps) to keep track of character counts for s1 and the current window in s2.
// 4. If the frequency arrays match at any point, return true.

// Time Complexity: O(n) - where n is the length of s2, as we are traversing through s2 once.
// Space Complexity: O(1) - as we are using fixed-size frequency arrays for characters (assuming only lowercase letters).

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        // Fill s1Counts and the first window of s2Counts
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        // Slide the window across s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Counts, s2Counts)) return true;
            
            // Move window: remove leftmost char, add next rightmost char
            s2Counts[s2.charAt(i) - 'a']--;
            s2Counts[s2.charAt(i + s1.length()) - 'a']++;
        }

        return matches(s1Counts, s2Counts);
    }

    private boolean matches(int[] s1Counts, int[] s2Counts) {
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] != s2Counts[i]) return false;
        }
        return true;
    }
}

// Alternative approach using HashMaps:

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // Count frequency of characters in s1
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            // Add current character to window
            char current = s2.charAt(right);
            windowMap.put(current, windowMap.getOrDefault(current, 0) + 1);

            // If window exceeds the size of s1, remove the leftmost character
            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                if (windowMap.get(leftChar) == 1) {
                    windowMap.remove(leftChar);
                } else {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++; // Shrink window
            }

            // Check if windowMap equals s1Map (valid permutation)
            if (windowMap.equals(s1Map)) return true;

            right++; // Expand window
        }

        return false;
    }
}
