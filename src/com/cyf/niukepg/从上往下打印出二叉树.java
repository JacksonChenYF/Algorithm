package com.cyf.niukepg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/3 17:14
 * @Description:从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从上往下打印出二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
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


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
