package org.algorithm.chenjk.base.tree;

/**
 * @class: Trie 字典树
 * @description: 特性：
 * - 根节点没有字符路径。除根节点外，每一个节点都被一个字符路径找到。
 * - 从根节点到某一节点，将路径上经过的字符连接起来，为对应字符串。
 * - 每个节点向下所有的字符路径上的字符都不同
 * 每个结点维持两个变量的记录：
 * path表示字符路过这个结点的次数（即表示存在以当前结点为前缀的字符有多少个）；
 * end记录以当前结点为结束的字符有多少个。
 * @author: jack
 * @create: 2023-06-07 22:03
 **/
public class TrieTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("a");
        trie.add("ab");
        trie.add("ac");
        trie.add("abc");
        System.out.println(trie.getPre("ab"));
    }

    static class Trie {

        /** root节点，不存数据 */
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void add(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char c : chars) {
                index = c - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public int get(String word) {
            if (word == null) return 0;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char c : chars) {
                index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                // 说明char 存在
                node = node.nexts[index];
            }
            // 全部遍历完，node就走到了word的最终节点
            return node.end;
        }

        public int getPre(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char c : chars) {
                index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }

    }

    static class TrieNode {

        /** 表示字符路过这个结点的次数（即表示存在以当前结点为前缀的字符有多少个） */
        public int path;

        /** 以当前结点为结束的字符有多少个 */
        public int end;

        public TrieNode[] nexts;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            nexts = new TrieNode[26];
        }
    }

}
