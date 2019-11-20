package com.cyf.niukeoffer;

import java.util.Arrays;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/13 15:40
 * @Description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字 。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 思路：每颗子树的根节点肯定是pre子数组的首元素，所以每次新建一个子树的根节点
 * <p>
 * 递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，前序的开始结束索引通过计算中序中左右子树的大小来计算，
 * 然后递归求解，直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回左子树活右子树的根节点
 *
 * 练习：11.20->success
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length) {
            throw new RuntimeException("前序遍历数组长度与中序遍历数组长度不相等");
        }
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        //此处的i必须从0开始,因为头节点可能都在第一个位置  break:只有一次条件成立
        for (int i = 0; i < in.length; ++i) {
            if (root.val == in[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);  //每颗子树的根节点肯定是pre子数组的首元素，所以每次新建一个子树的根节点

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        if (pre.length != in.length) {
            throw new RuntimeException("前序与中序元素不一样多");
        }
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; ++i) {
            if (root.val == in[i]) {
                root.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
