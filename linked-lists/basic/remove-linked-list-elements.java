// Problem: Remove Linked List Elements
// Platform: LeetCode
// Link: https://leetcode.com/problems/remove-linked-list-elements/
// Difficulty: Easy

// Approach: 
// We can use an iterative approach to remove elements from the linked list in O(n) time, where n is the number of nodes in the list.
// 1. We will maintain a dummy node to simplify the removal process.
// 2. We will iterate through the list and remove nodes with the specified value.
// 3. We will continue this process until we have processed all nodes.

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}

// Another approach is to use recursion to remove elements from the linked list in O(n) time, where n is the number of nodes in the list.
// 1. We will recursively call the function on the next node until we reach the end of the list.
// 2. We will check if the current node's value is equal to the specified value. If it is, we will skip the current node by returning the result of the recursive call on the next node.

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}