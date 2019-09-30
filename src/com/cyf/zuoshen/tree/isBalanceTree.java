package com.cyf.zuoshen.tree;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/16 12:58
 * @Description: 判断一颗树是否为平衡二叉树
 * 1、平衡二叉树：对于任何一个节点的左右子树高度不超过1
 * 2、思路：设计一个类型返回一个参数是 是否为二叉树；一个参数为子树的高度
 */
public class isBalanceTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //返回的类型
    public static class ReturnDate{
        public boolean isB;
        public int h;

        public ReturnDate(boolean isB,int h){
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isBalance(Node head){
        return process(head).isB;
    }

    public static ReturnDate process(Node head){
        if (head == null){
            return new ReturnDate(true,0);
        }
        ReturnDate leftData = process(head.left);
        if (!leftData.isB){
            return new ReturnDate(false,0);
        }
        ReturnDate rightData = process(head.right);
        if (!rightData.isB){
            return new ReturnDate(false,0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1){
            return new ReturnDate(false , 0);
        }
        return new ReturnDate(true , Math.max(leftData.h,rightData.h) + 1);
    }
}
