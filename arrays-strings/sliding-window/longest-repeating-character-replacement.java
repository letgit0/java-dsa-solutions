// Problem: Longest Repeating Character Replacement
// Platform: Leetcode
// Link: https://leetcode.com/problems/longest-repeating-character-replacement/
// Difficulty: Medium

// Approach:
// 1. Use a sliding window to keep track of the current substring.
// 2. Use a frequency array to count the occurrences of each character in the current window.
// 3. Keep track of the count of the most frequent character in the current window.
// 4. If the length of the current window minus the count of the most frequent character is greater than k, it means we need to shrink the window from the left.
// 5. Keep track of the maximum length of the valid window found during the process.

// Time Complexity: O(n) - where n is the length of the string.
// Space Complexity: O(1) - as we are using a fixed-size frequency array for uppercase letters.

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCount = new int[26];
        int maxCount = 0; // Count of the most frequent character in the current window
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            charCount[c - 'A']++;
            maxCount = Math.max(maxCount, charCount[c - 'A']);

            // If the number of characters to replace exceeds k, shrink the window
            while (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'A']--;
                left++;
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}