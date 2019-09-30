package com.cyf.niukepg;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 */
public class 反转链表 {

    public static ListNode ReverseList(ListNode head) {
        /*//递归法
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;*/

        //循环操作
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(node1);
        System.out.println(ReverseList(node1));
    }


}
