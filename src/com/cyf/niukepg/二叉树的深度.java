package com.cyf.niukepg;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/24 10:31
 * @Description:输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径， 最长路径的长度为树的深度。
 */
public class 二叉树的深度 {

    /**
     * 递归方法：
     * 如果该树只有一个结点，它的深度为1.如果根节点只有左子树没有右子树，那么树的深度为左子树的深度加1；
     * 同样，如果只有右子树没有左子树，那么树的深度为右子树的深度加1。
     * 如果既有左子树也有右子树，那该树的深度就是左子树和右子树的最大值加1.
     *
     * @param root
     * @return
     */
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 非递归版本（层次遍历）[广度优先遍历]
     * 经典：利用辅助队列，先将头节点入队列，当队列不空时出队列的节点记为top，
     * 当top左节点不空时入队列，其右节点不空时入队列，如此循环即可。
     * <p>
     * 求深度：构造变量count记录当前层访问到的节点数，nextCount记录当前层的总个数，每当访问过一层层数depth++；
     *
     * @param root
     * @return
     */
    public static int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if (count == nextCount) { //2
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        //System.out.println(TreeDepth(node1));
        System.out.println(TreeDepth(node1));
    }
}
