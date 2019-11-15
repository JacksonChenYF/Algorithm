package com.cyf.zuoshen.tree;

import java.util.Stack;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/7 09:37
 * @Description: 递归(非递归) 实现先中后遍历二叉树
 * <p>
 * 练习次数：先序：3->10.8success
 * 中序：1 -> 10.8fail; 2 -> 10.9success
 */
public class preinPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //先序遍历
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 非递归先序遍历二叉树：
     * 思路：最开始head不为空，则压入栈；
     * 当栈不为空时，弹出并打印栈顶，先判断右子树是否需压栈，再判断左子树；（易错点：先右后左）
     * 再判断栈不为空，弹出栈顶，再判断；
     *
     * @param head
     */
    //非递归
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

    //中序遍历
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 非递归遍历二叉树思路：若head不为空，则创建栈；内嵌判断：栈或head是否不为空，
     * 1、若head不为空，则压栈，遍历左节点；2、所head为空，则弹出打印当前栈；遍历右节点；
     * <p>
     * 当前栈不为空，节点为空，即从栈中拿出一个 打印，当前节点向右，若依然为空，则弹出栈中元素，往右；
     * 接着来到右节点的孩子，若不为空则压入栈，当前节点往左；
     *
     * @param head
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    /**
     * 思路：非递归后序遍历：两个栈，一个为辅助栈
     * 把先序遍历中需要输出的位置换成压入辅助栈。最后循环输出辅助栈元素即可；
     *
     * @param head
     */
    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /*
    分割测试代码
     */

    public static void preT(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        preT(head.left);
        preT(head.right);
    }

    public static void preTr(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                System.out.println(temp.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void inT(Node head) {
        if (head == null) {
            return;
        }
        inT(head.left);
        System.out.println(head.value);
        inT(head.right);
    }

    public static void inTr(Node head) {

    }

    public void preTree1(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preTree1(head.left);
        preTree1(head.right);
    }

    public void preTree11(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            System.out.println(tmp.value);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public void preTree2(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preTree2(head.left);
        preTree2(head.right);
    }

    public void preTree22(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            stack.push(head);
            while (!stack.isEmpty()) {
                Node tmp = stack.pop();
                System.out.println(tmp);
                if (tmp.right != null) {
                    stack.push(tmp.right);
                }
                if (tmp.left != null) {
                    stack.push(tmp.left);
                }
            }
        }

    }

    public void preTree3(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            System.out.println(tmp.value);

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public void preTree33(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preTree33(head.left);
        preTree33(head.right);
    }

    public void inTree1(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }

    }

    public void inTree11(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

}
