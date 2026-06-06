// Problem: Reverse Linked List
// Platform: LeetCode
// Link: https://leetcode.com/problems/reverse-linked-list/
// Difficulty: Easy

// Approach: 
// We can use an iterative approach to reverse the linked list in O(n) time, where n is the number of nodes in the list.
// 1. We will maintain three pointers: previous, current, and next.
// 2. We will iterate through the list and update the links to reverse the direction of each node.

// Time Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Store the next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous to current
            current = next; // Move to the next node
        }

        return previous; // At the end, previous will be the new head of the reversed list
    }
}

// We can also use a recursive approach to reverse the linked list in O(n) time and O(n) space due to the call stack.

class Solution {
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive case: reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Reverse the current node's link
        head.next.next = head; // Make the next node point to the current node
        head.next = null; // Set the current node's next to null

        return newHead; // Return the new head of the reversed list
    }
}