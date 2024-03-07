package org.algorithm.chenjk.lc.linkedlist;

import org.algorithm.chenjk.base.model.ListNode;

/**
 * @class: L19  删除链表的倒数第 N 个结点
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @author: jack
 * @create: 2024-01-14 20:52
 **/
public class L19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = removeNthFromEnd(head, 5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode delIdx = head;
        ListNode endIdx = head;
        // 1, 1
        for (int i = n; i > 0; i--) {
            if (endIdx != null) {
                endIdx = endIdx.next;
            }
        }
        ListNode pre = null;
        while (endIdx != null) {
            endIdx = endIdx.next;
            pre = delIdx;
            delIdx = delIdx.next;
        }
        // 说明endIdx从头走到了尾，要删的是第一个元素,直接返回next
        if (pre == null) {
            return head.next;
        }
        pre.next = delIdx.next;
        return head;
    }
}
