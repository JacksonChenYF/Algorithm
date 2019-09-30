package com.cyf.zuoshen.tree;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/16 08:59
 * @Description: 序列化二叉树
 */
public class SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先序序列化二叉树（递归）
     * @param head
     * @return
     */
    public static String serialBypre(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialBypre(head.left);
        res += serialBypre(head.right);
        return res;
    }
}
