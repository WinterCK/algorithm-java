package org.algorithm.chenjk.lc.linkedlist;

import org.algorithm.chenjk.base.model.ListNode;

/**
 * @class: L83 删除排序链表中的重复元素
 * @description: 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * @author: jack
 * @create: 2024-01-14 21:17
 **/
public class L83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3))));
        ListNode node = deleteDuplicates(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode v = new ListNode(Integer.MIN_VALUE);
        v.next = head;
        ListNode cur = head;
        ListNode pre = v;
        while (cur != null) {
            // 相等，则pre.next指向cur的下一位（跳过cur节点），但不移动pre, 只移动cur,供下次继续判断
            if (pre.val == cur.val) {
                pre.next = cur.next;
                cur = cur.next;
                continue;
            }
            // 不相等，则一起前进
            cur = cur.next;
            pre = pre.next;
        }
        return v.next;
    }
}
