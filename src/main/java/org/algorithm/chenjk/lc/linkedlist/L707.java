package org.algorithm.chenjk.lc.linkedlist;

import org.algorithm.chenjk.base.model.ListNode;

/**
 * @class: L707 设计链表
 * @description:
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 * @author: jack
 * @create: 2024-01-14 14:26
 **/
public class L707 {

    /**
     *
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addAtHead(2);
        linkedList1.deleteAtIndex(1);
        linkedList1.addAtHead(2);
        linkedList1.addAtHead(7);
        linkedList1.addAtHead(3);
        linkedList1.addAtHead(2);
        linkedList1.addAtHead(5);
        linkedList1.addAtTail(5);
        linkedList1.get(5);
        linkedList1.deleteAtIndex(6);
        linkedList1.deleteAtIndex(4);

        System.out.println(linkedList1.get(0));

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(3);
        linkedList.addAtHead(1);
        linkedList.addAtTail(5);
        linkedList.addAtIndex(0, 0);
        linkedList.addAtIndex(5, 100);
        linkedList.addAtIndex(4, 6);
        linkedList.addAtIndex(2, 2);

        ListNode head = linkedList.getHead();
        while (head != null) {
            System.out.printf(head.val + ",");
            head = head.next;
        }
        System.out.println();
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println("length: " +linkedList.listNodeLength);
        linkedList.deleteAtIndex(0);
        linkedList.deleteAtIndex(2);
        ListNode cur = linkedList.getHead();
        while (cur != null) {
            System.out.printf(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }

    static class MyLinkedList {

        ListNode head;
        int listNodeLength;

        public MyLinkedList() {
            // 虚拟head
            head = new ListNode(Integer.MIN_VALUE);
        }

        public ListNode getHead() {
            return head.next;
        }

        /**
         * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
         * @param index idx
         * @return val
         */
        public int get(int index) {
            if (index >= listNodeLength) {
                return -1;
            }
            ListNode cur = this.head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点
         * @param val val
         */
        public void addAtHead(int val) {
            ListNode valNode = new ListNode(val);
            if (this.head.next != null) {
                valNode.next = this.head.next;
            }
            this.head.next = valNode;
            listNodeLength ++;
        }

        /**
         * 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
         * @param val val
         */
        public void addAtTail(int val) {
            if (listNodeLength == 0) {
                this.head.next = new ListNode(val);
                listNodeLength ++;
                return;
            }
            ListNode cur = this.head.next;
            ListNode pre = null;
            while (cur != null) {
                pre = cur;
                cur = cur.next;
            }
            if (pre != null)
                pre.next = new ListNode(val);
                listNodeLength ++;
        }

        /**
         * 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
         * 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
         * 如果 index 比长度更大，该节点将 不会插入 到链表中
         * @param index idx
         * @param val val
         */
        public void addAtIndex(int index, int val) {
            if (index > listNodeLength) {
                return;
            }
            if (index == listNodeLength) {
                addAtTail(val);
                return;
            }
            ListNode valNode = new ListNode(val);
            ListNode cur = this.head.next;
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = valNode;
            valNode.next = cur;
            listNodeLength++;
        }

        /**
         * 如果下标有效，则删除链表中下标为 index 的节点
         * @param index idx
         */
        public void deleteAtIndex(int index) {
            // index最大为listNodeLength - 1
            if (index >= listNodeLength) {
                return;
            }
            ListNode cur = this.head.next;
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = cur;
                cur = cur.next;
            }
            if (cur.next != null) {
                pre.next = cur.next;
                listNodeLength--;
            } else {
                pre.next = null;
                listNodeLength--;
            }
        }
    }


}
