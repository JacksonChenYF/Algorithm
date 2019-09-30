package com.cyf.zuoshen.tree;

/**
 * @Auther: ChenYF
 * @Date: 2019/7/14 14:47
 * @Description:在二叉树中找到一个节点的后继节点（中序为例）
 * 1、若当前节点有右子树，则下一节点为其右子树最左的节点
 * 2、若当前节点x没有右子树，则遍历其父节点，若不是其父节点的左孩子，则继续遍历父节点，
 * 则到当前元素的父为其左孩子，则该父为其后序节点；
 */
public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;//指向父节点的parent指针
        
        public Node(int data) {
            this.value = data;
        }
    }
    
    public static Node getSuccessorNode(Node node){
        if (node == null) {
            return node;
        }
        if (node.right != null){
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            //停止条件为父节点左孩子为node
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }


    /**
     * 找当前子树最左的节点
     * @param node :为当前子树的头部
     * @return
     */
    private static Node getLeftMost(Node node) {
        if (node.left == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
