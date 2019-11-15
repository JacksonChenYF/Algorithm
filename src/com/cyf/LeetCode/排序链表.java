package com.cyf.LeetCode;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/3 23:08
 * @Description:在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 思路：(n log n) -> 二分 -> 归并
 */
public class 排序链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);

    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;

        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);

    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }

        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }
}
