// Problem: Linked List Cycle II
// Platform: LeetCode
// Link: https://leetcode.com/problems/linked-list-cycle-ii/
// Difficulty: Medium

// Approach: 
// 1. Use two pointers, one slow and one fast.
// 2. Move the slow pointer by one step and the fast pointer by two steps.
// 3. If there is a cycle, the fast pointer will eventually meet the slow pointer.
// 4. Once they meet, move one pointer to the head of the list and keep the other pointer at the meeting point.
// 5. Move both pointers one step at a time until they meet again. The point at which they meet will be the start of the cycle.

// Time Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Step 1: Find the meeting point in the cycle (if it exists)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Step 2: Move one pointer to the head and keep the other at the meeting point
                slow = head;
                
                // Step 3: Move both pointers one step at a time until they meet again
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow; // The start of the cycle
            }
        }
        
        return null; // No cycle
    }   
}