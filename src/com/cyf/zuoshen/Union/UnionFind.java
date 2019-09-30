package com.cyf.zuoshen.Union;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/5 15:34
 * @Description:并查集查找: 1查是否属于一个集合内的 2集合合并
 */
public class UnionFind {

    public static class UnionFindSet{
        public HashMap<Node, Node> fatherMap;   //key:child value:father
        public HashMap<Node, Integer> sizeMap;  //

    public static class Node {
        //whatever yuu like String , int ...
    }

    public UnionFindSet(List<Node> nodes) {
        makeSets(nodes);
    }

    private void makeSets(List<Node> nodes) {
        fatherMap = new HashMap<Node, Node>();
        sizeMap = new HashMap<Node,Integer>();
        for (Node node : nodes){
            fatherMap.put(node, node);
            sizeMap.put(node,1);
        }
    }

        /**
         * 查顶级父节点，优化：把沿路的节点优化为直接挂在头节点
         * @param node
         * @return
         */
    private Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        fatherMap.put(node,father);
        return father;
    }

    public boolean isSameSet(Node a , Node b) {
        return findHead(a) == findHead(b);
    }

    public void union(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        if (aHead != bHead){
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            if (aSetSize <= bSetSize) {
                fatherMap.put(aHead,bHead);
                sizeMap.put(bHead,aSetSize + bSetSize);
            } else {
                fatherMap.put(bHead,aHead);
                sizeMap.put(aHead,aSetSize + bSetSize);
            }
        }
    }

    }
}
