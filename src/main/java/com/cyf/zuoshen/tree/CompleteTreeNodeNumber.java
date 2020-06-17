package com.cyf.zuoshen.tree;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/29 13:19
 * @Description: 已知一颗完全二叉树，求其节点个数
 */
public class CompleteTreeNodeNumber {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(Node node , int level , int h){
        if (level == h){
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    public static int mostLeftLevel(Node node , int level){
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }

}
