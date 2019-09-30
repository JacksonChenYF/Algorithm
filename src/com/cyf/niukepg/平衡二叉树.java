package com.cyf.niukepg;

import sun.reflect.generics.tree.Tree;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/28 19:24
 * @Description:输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
