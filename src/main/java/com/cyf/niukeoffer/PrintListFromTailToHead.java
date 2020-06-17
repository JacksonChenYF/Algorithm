package com.cyf.niukeoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/11 10:26
 * @Description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 思路：1、额外栈存储
 * 2、pop到数组中
 *
 * 练习：11.19 ->success
 */
public class PrintListFromTailToHead {

    //额外栈存储
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> temp = new Stack<>();
        ArrayList<Integer> newArrayList = new ArrayList<>();

        while (listNode != null) {
            temp.add(listNode.val);
            listNode = listNode.next;
        }

        while (!temp.isEmpty()) {
            newArrayList.add(temp.pop());
        }
        return newArrayList;

    }

    //pop到数组中
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> newArrayList = new ArrayList<>();

        if (listNode != null) {
            stack.push(listNode.val);
            while (listNode.next != null) {
                stack.push(listNode.next.val);
                listNode = listNode.next;
            }
        } //可优化

        while (!stack.isEmpty()) {
            newArrayList.add(stack.pop());
        }
        return newArrayList;
    }

    public static ArrayList<Integer> printList(ListNode listNode) {
        ArrayList<Integer> newArrayList = new ArrayList<>();
        Stack<Integer> temp = new Stack<>();

        while (listNode != null) {
            temp.add(listNode.val);
            listNode = listNode.next;
        }

        while (!temp.isEmpty()) {
            newArrayList.add(temp.pop());
        }
        return newArrayList;
    }

}

