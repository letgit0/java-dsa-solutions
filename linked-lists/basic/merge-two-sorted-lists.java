// Problem: Merge Two Sorted Lists
// Platform: LeetCode
// Link: https://leetcode.com/problems/merge-two-sorted-lists/
// Difficulty: Easy

// Approach: 
// We can use an iterative approach to merge the two sorted lists in O(m + n) time, where m and n are the lengths of the two lists.
// 1. We will maintain a dummy node to simplify the merging process.
// 2. We will compare the values of the nodes from both lists and attach the smaller one to the result list.
// 3. We will continue this process until one of the lists is exhausted.
// 4. Finally, we will attach any remaining nodes from the non-exhausted list.

// Time Complexity: O(m + n)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = null;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        ListNode temp3 = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp3.next = temp1;
                temp3 = temp1;
                temp1 = temp1.next;
            }else{
                temp3.next = temp2;
                temp3 = temp2;
                temp2 = temp2.next;
            }
        }
        while(temp1 != null){
            temp3.next = temp1;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }
        while(temp2 != null){
            temp3.next = temp2;
            temp3 = temp3.next;
            temp2 = temp2.next;
        }
        return head;
    }
}

// Alternative Approach: Recursive
// We can also use a recursive approach to merge the two sorted lists.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}