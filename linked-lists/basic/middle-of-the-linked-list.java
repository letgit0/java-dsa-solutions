// Problem: Middle of the Linked List
// Platform: LeetCode
// Link: https://leetcode.com/problems/middle-of-the-linked-list/
// Difficulty: Easy

// Approach: 
// We can use the two-pointer technique to find the middle of the linked list in O(n) time, where n is the number of nodes in the list.
// 1. We will maintain two pointers, slow and fast, both initially pointing to the head of the list.
// 2. We will move the slow pointer one step at a time and the fast pointer two steps at a time.
// 3. When the fast pointer reaches the end of the list, the slow pointer will be at the middle.

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
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}