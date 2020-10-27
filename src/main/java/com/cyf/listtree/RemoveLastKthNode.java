package com.cyf.listtree;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/15 18:45
 * @Description:
 */
public class RemoveLastKthNode {

    //删除第K个节点
    public Node removeLastKthNode(Node head, int K) {
        if(head == null || K < 1)
            return head;
        Node temp = head;
        int num = 0;
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        if (num == K) {
            return head.next;
        }
        if (num > K) {
            temp = head;
            //删除第(num-k+1)个节点
            //定位到这个点的前驱
            while (num - K != 0) {
                temp = temp.next;
                num--;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    //节点
    class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

}
