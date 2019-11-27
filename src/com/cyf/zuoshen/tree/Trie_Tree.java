package com.cyf.zuoshen.tree;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/27 15:12
 * @Description: 前缀树
 */
public class Trie_Tree {

    public static class TrieNode {
        public int path;    //经过节点的次数
        public int end;     //作为结尾的次数
        public TrieNode[] nexts;    //路数（边） 值插在边上，而不是结点

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];   //a--z
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 1、插入字符串“abc” -toCharArray- {a,b,c}
         * 2、index = chs[i] - 'a'; -- a - a = 0 | b - a = 1 ...以此类推
         * 3、node.path++; -- 每经过一次+1 ：表明被经过一次
         * 4、node.end++; -- 循环结束end+1 ：表明有一个字符串以此结尾； 引用：可查以此结尾的字符串有几个
         *
         * @param word
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        /**
         * 1、--node.nexts[index].path == 0 //判断删除过程某节点path减完是否为空，是的话直接把后续节点删除
         *
         * @param word
         */
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /**
         * 查询字符串储存次数
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 查某个值前缀数量（经过几次）
         *
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }

}
