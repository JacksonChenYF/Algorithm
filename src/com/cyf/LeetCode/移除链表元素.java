package com.cyf.LeetCode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class 移除链表元素 {
    //递归
    public ListNode reverseList(ListNode head) {
        //1.终止
        if(head == null || head.next == null)
            return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
