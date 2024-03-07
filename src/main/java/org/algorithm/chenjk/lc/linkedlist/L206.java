package org.algorithm.chenjk.lc.linkedlist;

import org.algorithm.chenjk.base.model.ListNode;

/**
 * @class: L206 反转链表
 * @description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author: jack
 * @create: 2024-01-14 20:20
 **/
public class L206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = reverseList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        pre.next = null;
        while (cur != null) {
            ListNode tmpNext = cur.next;
            // ListNode tmp = cur;
            cur.next = pre;
            pre = cur;
            cur = tmpNext;
        }
        return pre;
    }
}
