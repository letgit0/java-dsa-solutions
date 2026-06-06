// Problem: Linked List Cycle 
// Platform: LeetCode
// Link: https://leetcode.com/problems/linked-list-cycle/
// Difficulty: Easy

// Approach: 
// We can use the fast and slow pointer approach to detect if there is a cycle in the linked list.
// 1. We will initialize two pointers, slow and fast, to the head of the linked list.
// 2. We will move the slow pointer one step at a time and the fast pointer two steps at a time.
// 3. If there is a cycle in the linked list, the fast pointer will eventually meet the slow pointer. If there is no cycle, the fast pointer will reach the end of the linked list.

// Time Complexity: O(n) where n is the number of nodes in the linked list.
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }