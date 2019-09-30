package com.cyf.zuoshen.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/27 10:53
 * @Description:判断一棵树是否为完全二叉树
 * 1. 完全二叉树：叶子只能出现在最下面的二层， 最下层的叶子一定集中在左部的连续位置，
 *              倒数第二层，若有叶子结点 一定在右部连续位置
 *              如果结点的度为1 ,则该结点只有左孩子， 同样结点的二叉树,完全二叉树的深度最小
 *
 * 2.思路：情况1：如果一个节点左孩子为空，右孩子不为空，直接返回false；l == null && r != null
 *        情况2：如果一个接待你左孩子不为空，右孩子为空，则遍历后续节点是否左右孩子都为空；
 *
 * Queue<Node> queue = new LinkedList<Node>();
 * queue是一个先进先出队列，画出一个栈图可知晓整个流程。
 */
public class isCompletebinarytree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();//双端链表可实现队列
        boolean leaf = false; // 表明是否开启这个阶段
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null))
                ||
                    (l == null && r != null)){
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }else {
                leaf = true;
            }
        }
        return true;
    }
}
