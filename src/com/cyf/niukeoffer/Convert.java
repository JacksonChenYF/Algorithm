package com.cyf.niukeoffer;

import java.util.Stack;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/27 09:26
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {

    /**
     * 方法一：非递归版
     * 解题思路：
     * 1.核心是中序遍历的非递归算法。
     * 2.修改当前遍历节点与前一遍历节点的指针指向。
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;    //用于保存中序遍历序列的上一节点
        boolean isFirst = true;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();    //中序遍历第一个节点（最小值）
            if (isFirst) {
                pRootOfTree = p;    //pRootOfTree的内存指向p,对p的改动会同步给pRootOfTree
                pre = pRootOfTree;
                isFirst = false;
            } else {                //构建双向链表
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}