/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.linkedlist.hard;

import java.util.PriorityQueue;

/**
 *
 * @author youngjucho
 */
public class MergekSortedLists {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1, ListNode l2)->Integer.compare(l1.val, l2.val));
        
        for (ListNode list : lists) {
            if (list != null) 
                pq.offer(list);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null)
                pq.offer(tail.next);
        } 
        return dummy.next;
    }

}
