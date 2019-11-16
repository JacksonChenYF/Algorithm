package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/23 17:26
 * @Description:输入一个链表，输出该链表中倒数第k个结点。 推： k-1 -> k-1>0 -> k > 1
 * <p>
 * 练习：11.09 fail、11.10 success(记录k)
 */
public class 链表中倒数第k个结点 {

    public static class Solution {

        /**
         * @param head
         * @param k
         * @return p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
         * 当p指针跑到最后时，pre所指指针就是倒数第k个节点
         */
        public static ListNode FindKthToTail(ListNode head, int k) {
            ListNode pre = head, p = head;
            int a = k;
            int count = 0;
            while (p != null) {
                p = p.next;
                count++;
                if (k < 1) {
                    pre = pre.next;
                }
                k--;
            }
            if (count < a)
                return null;
            return pre;

        }

        public static ListNode FindKthToTail1(ListNode head, int k) {
            ListNode pre = head, p = head;
            int a = k;
            int count = 0;
            while (p != null) {
                p = p.next;
                count++;
                if (k < 1) {
                    pre = pre.next;
                }
                k--;
            }
            if (count < a)
                return null;
            return pre;

        }

        public static ListNode FindKthToTail2(ListNode head, int k) {
            ListNode pre = head, p = head;
            int a = k;
            int count = 0;
            while (p != null) {
                p = p.next;
                count++;

                if (k < 1) {
                    pre = pre.next;
                }
                k--;
            }
            if (a > count)
                return null;

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
            System.out.println(FindKthToTail(node1, 1));
        }
    }

}
