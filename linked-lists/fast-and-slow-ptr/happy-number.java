// Problem: Happy Number
// Platform: LeetCode
// Link: https://leetcode.com/problems/happy-number/
// Difficulty: Easy

// Approach: 
// 1. Use two pointers, one slow and one fast.
// 2. Move the slow pointer by one step and the fast pointer by two steps.
// 3. If there is a cycle, the fast pointer will eventually meet the slow pointer.
// 4. If the fast pointer reaches 1, then the number is a happy number.

// Time Complexity: O(log n)
// Space Complexity: O(1)

public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);
        
        return slow == 1;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}