package com.cyf.niukeoffer;

import java.util.ArrayList;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/10 09:58
 * @Description: 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 11.11 -> succ、
 */
public class FindPath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list)); //不重新new的话从始至终listAll中所有引用都指向了同一个一个list
        }

        findPath(root.left, target);
        findPath(root.right, target);

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
