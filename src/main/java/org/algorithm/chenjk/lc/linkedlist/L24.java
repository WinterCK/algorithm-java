package org.algorithm.chenjk.lc.linkedlist;

import org.algorithm.chenjk.base.model.ListNode;

/**
 * @class: L24 两两交换链表中的节点
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。必须在不修改节点内部的值的情况下完成本题
 * （即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * @author: jack
 * @create: 2024-01-14 20:27
 **/
public class L24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = swapPairs(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode v = new ListNode(-1);
        v.next = head;
        ListNode cur = v;
        // 注意判断
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            ListNode third = cur.next.next.next;
            cur.next = second;
            second.next = first;
            first.next = third;
            cur = first;
        }
        return v.next;
    }

    public static ListNode swapPairsDiGui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
