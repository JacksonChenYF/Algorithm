package com.cyf.niukepg;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/11 10:26
 * @Description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 思路：1、额外栈存储
 *      2、pop到数组中
 */
public class 从尾到头打印链表1 {

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

}

