package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/26 17:21
 * @Description:操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class 二叉树的镜像 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        Mirror(root.left);
        Mirror(root.right);

    }

}
