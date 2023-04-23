package org.algorithm.chenjk.base.model;

/**
 * @project: algorithm-test
 * @description: LC 链表Node常用数据结构
 * @author: chenjk
 * @create: 2023-03-01 23:41
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
