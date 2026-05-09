// Problem: Valid Palindrome
// Platform: Leetcode
// Link: https://leetcode.com/problems/valid-palindrome/
// Difficulty: Easy

// Approach:
// Use two pointers, one at the beginning and one at the end of the string.
// Move the pointers towards each other, skipping non-alphanumeric characters.
// Compare the characters at the pointers (case-insensitive).
// If all corresponding characters match, it's a valid palindrome.

// Time Complexity: O(n) - for iterating through the string once.
// Space Complexity: O(1) - only using a constant amount of extra space

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters at left and right pointers (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Not a palindrome
            }

            left++;
            right--;
        }

        return true; // It's a palindrome
    }
}