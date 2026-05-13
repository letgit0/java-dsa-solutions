// Problem: Minimum Window Substring
// Platform: Leetcode
// Link: https://leetcode.com/problems/minimum-window-substring/
// Difficulty: Hard

// Approach:
// 1. Use a sliding window to keep track of the current substring in s.
// 2. Use a frequency array (or hash map) to count the characters in t and the current window in s.
// 3. Expand the right pointer to include new characters until all characters in t are included in the current window.
// 4. Once all characters are included, try to shrink the window from the left to find the minimum window that still contains all characters of t.
// 5. Keep track of the minimum length and the starting index of the valid window found during the process.

// Time Complexity: O(n) - where n is the length of s, as we are traversing through s once.
// Space Complexity: O(1) - as we are using fixed-size frequency arrays for characters.

public String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";

    int[] targetMap = new int[128];
    for (char c : t.toCharArray()) targetMap[c]++;

    int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
    int count = t.length(); // Total characters we need to match

    while (right < s.length()) {
        // If we find a character that's in 't', decrement count
        if (targetMap[s.charAt(right)] > 0) {
            count--;
        }
        // Always decrement the frequency in our "needs" map
        targetMap[s.charAt(right)]--;
        right++;

        // When count == 0, we have a valid window!
        while (count == 0) {
            // Update our best result
            if (right - left < minLen) {
                minLen = right - left;
                startIndex = left;
            }

            // Try to shrink from the left
            targetMap[s.charAt(left)]++;
            // If the char we just removed was essential, increment count
            if (targetMap[s.charAt(left)] > 0) {
                count++;
            }
            left++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
}