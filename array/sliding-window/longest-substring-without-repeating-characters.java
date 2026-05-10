// Problem: Longest Substring Without Repeating Characters
// Platform: Leetcode
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Difficulty: Medium

// Approach:
// 1. Use a sliding window to keep track of the current substring without repeating characters.
// 2. Use a hash set to store the characters in the current window.
// 3. Expand the right pointer to include new characters until a duplicate is found.
// 4. When a duplicate is found, move the left pointer to the right until the duplicate character is removed from the window.
// 5. Keep track of the maximum length of the substring found during the process.

// Time Complexity: O(n) - where n is the length of the string.
// Space Complexity: O(min(m, n)) - where m is the size of the character set and n is the length of the string.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        // A Set is better here since we only care if the char exists
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // If we find a duplicate, shrink the window from the left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            // Current window size is (right - left + 1)
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}