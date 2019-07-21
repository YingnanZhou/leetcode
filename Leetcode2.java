package com.baidu.domain;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //2 pointers point to the heads of two given lists
        ListNode q1 = l1, q2 = l2;
        //use dummy head as our result
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int sum = 0;
        //caculate the sum of nodes of according position, if one list has null node, just add up node in other list, we break the while loop when we reach the end of 2 lists  
        while(q1 != null || q2 != null) {
            if(q1 != null) {
                sum += q1.val;
                q1 = q1.next;
            }
            if(q2 != null) {
                sum += q2.val;
                q2 = q2.next;
            }
            p.next = new ListNode(sum % 10);
            //the value in sum is prepared of next loop caculation
            sum = sum / 10;
            p = p.next;
        }
        //special case, append the carry
        if(sum == 1) p.next = new ListNode(1);
        return dummy.next;
    }
}