package com.cyf.Testmyself;

import java.util.Stack;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/29 11:34
 * @Description:
 */
public class 先序遍历二叉树 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public void preTree(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + ' ');
        preTree(head.left);
        preTree(head.right);
    }

    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
}
