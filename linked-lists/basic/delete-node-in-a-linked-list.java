// Problem: Delete Node in a Linked List
// Platform: LeetCode
// Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
// Difficulty: Easy

// Approach: 
// We can use a simple approach to delete the given node in O(1) time, where n is the number of nodes in the list.
// 1. We will copy the value of the next node to the current node.
// 2. We will then delete the next node.

// Time Complexity: O(1)
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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}