package com.cyf.listtree;


/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 练习次数：递归：1->10.9success; 非递归：1 -> fail
 * 11.15 -> succcess
 * <p>
 * 思路：辅助点next：依次保存下次遍历的节点
 * pre为反向反转好的节点；每次都把遍历的节点的 下一节点指向它， 再回过头把遍历节点赋给它，完成反转；终止条件为head == null；
 */
public class 反转链表 {

    public static ListNode ReverseList(ListNode head) {
        /*//递归法
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;*/

        //循环操作
        ListNode pre = null;  //当前节点前驱
        ListNode next = null; //当前节点后驱

        while (head != null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static ListNode ReverseList3(ListNode head) {
        if (head == null) {
            return head;
        }
        return head;
    }

    public static ListNode ReverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = ReverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static ListNode ReverseList44(ListNode head) {
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

    public static ListNode ReverseList5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = ReverseList5(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static ListNode ReverseList55(ListNode head) {
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

//    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        System.out.println(node1);
//        System.out.println(ReverseList44(node1));
//    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
