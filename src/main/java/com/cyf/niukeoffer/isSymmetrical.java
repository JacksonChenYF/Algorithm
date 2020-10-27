package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/11 10:06
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 思路：1、首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 * 2、左子树的右子树和右子树的左子树相同即可，采用递归
 */
public class isSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comTree(pRoot.left, pRoot.right);
    }

    private boolean comTree(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return comTree(left.left, right.right) && comTree(left.right, right.left);
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
