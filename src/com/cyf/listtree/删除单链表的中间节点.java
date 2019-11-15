package com.cyf.listtree;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/15 16:09
 * @Description: 给定链表的头节点head，实现删除链表的中间节点的函数。
 */
public class 删除单链表的中间节点 {
    public static ListNode removeMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode fast = head.next.next; // 快指针
        ListNode slow = head; // 慢指针
        //slow最终指向中间节点的前驱
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //进行删除
        slow.next = slow.next.next;
        return head;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
