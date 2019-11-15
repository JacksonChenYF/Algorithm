package com.cyf.niukepg;

import java.util.ArrayList;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/10 09:58
 * @Description: 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 11.11 -> succ、
 */
public class 二叉树中和为某一值的路径 {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list)); //不重新new的话从始至终listAll中所有引用都指向了同一个一个list
        }

        FindPath(root.left, target);
        FindPath(root.right, target);

        list.remove(list.size() - 1); //移除最后一个元素，深度遍历完一条路径后需回退
        return listAll;
    }

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }

        FindPath1(root.left, target);
        FindPath1(root.right, target);

        list.remove(list.size() - 1);
        return listAll;
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
