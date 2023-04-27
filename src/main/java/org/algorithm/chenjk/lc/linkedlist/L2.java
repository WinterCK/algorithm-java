package org.algorithm.chenjk.lc.linkedlist;

import com.google.gson.Gson;
import org.algorithm.chenjk.base.model.ListNode;

/**
 * @project: algorithm-test
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @author: jack
 * @create: 2023-03-01 23:41
 **/
public class L2 {

    public static void main(String[] args) {
        ListNode root1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = addTwoNumbers(root1, root2);
        System.out.println(new Gson().toJson(res));

    }

    /**
     * 数学运算 ,时间O(1)
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 1, y = 1;
        int l1Val = 0, l2Val = 0;
        while (l1 != null) {
            l1Val += l1.val * x;
            x = x*10;
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Val += l2.val * y;
            y = y*10;
            l2 = l2.next;
        }
        int val = l1Val + l2Val;
        ListNode res = new ListNode();
        ListNode head = res;
        String z = String.valueOf(val);
        ListNode endRecord = new ListNode();
        // 从后到前取值，以达到逆序效果
        for (int i = z.length() - 1; i >= 0 ; i--) {
            res.val = Integer.parseInt(String.valueOf(z.charAt(i)));
            res.next = new ListNode();
            endRecord = res;
            res = res.next;
        }
        // 用endRecord是为了不让最后一个ListNode 的next 为一个new ListNode()
        endRecord.next = null;
        return head;
    }
}
