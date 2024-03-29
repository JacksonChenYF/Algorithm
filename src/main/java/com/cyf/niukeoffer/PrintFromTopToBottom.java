package com.cyf.niukeoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/3 17:14
 * @Description:从上往下打印出二叉树的每个节点，同层节点从左至右打印。 次数：1->10.9success 2->1.14success
 * 思路：二叉树的广度优先遍历
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return arrayList;
        }
        queue.add(root);

        while (queue.size() != 0) {
            TreeNode tmp = queue.poll();
            arrayList.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> printFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return arrayList;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            arrayList.add(tmp.val);

            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return arrayList;
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
