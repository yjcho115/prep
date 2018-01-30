/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.linkedlist.medium;

/**
 *
 * @author youngjucho
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
 */
public class RemoveNthNodeFromEndofList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i=0; i<=n; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next =  second.next.next;
        return dummy.next;
    }
    
}
