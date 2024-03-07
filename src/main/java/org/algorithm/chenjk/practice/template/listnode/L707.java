package org.algorithm.chenjk.practice.template.listnode;

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

    }

    class MyLinkedList {

        public MyLinkedList() {

        }

        /**
         * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
         * @param index idx
         * @return val
         */
        public int get(int index) {
            return 0;
        }

        /**
         * 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点
         * @param val val
         */
        public void addAtHead(int val) {

        }

        /**
         * 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
         * @param val val
         */
        public void addAtTail(int val) {

        }

        /**
         * 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
         * 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
         * 如果 index 比长度更大，该节点将 不会插入 到链表中
         * @param index idx
         * @param val val
         */
        public void addAtIndex(int index, int val) {

        }

        /**
         * 如果下标有效，则删除链表中下标为 index 的节点
         * @param index idx
         */
        public void deleteAtIndex(int index) {

        }
    }


}
