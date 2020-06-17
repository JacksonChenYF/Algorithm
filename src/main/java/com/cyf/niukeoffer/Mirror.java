package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/12/3 09:57
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        //错误做法：这样交换只是把root左右子树的值交换与root无关 swap(root.left, root.right);
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /*public void swap(TreeNode node1, TreeNode node2) {
        TreeNode temp = node1;
        node1 = node2;
        node2 = temp;
    }*/

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

}
