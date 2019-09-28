/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//use a sum variable, to compute current node's value and record the carry to next compution.
//in the end of while loop, if carry is 1, we should add a new node.
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int sum = 0;
        while(p1 != null || p2 != null) {
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            ListNode node = new ListNode(sum % 10);
            p.next = node;
            p = p.next;
            sum /= 10;
        }
        if(sum == 1) p.next = new ListNode(1);
        return dummy.next;
    }
}