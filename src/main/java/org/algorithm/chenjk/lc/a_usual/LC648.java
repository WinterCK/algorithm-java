package org.algorithm.chenjk.lc.a_usual;

import java.util.*;

/**
 * @class: LC648 单词替换
 * @description: 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。
 * 例如，词根an，跟随着单词other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
 * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * @author: jack
 * @create: 2023-06-04 13:45
 **/
public class LC648 {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(myReplaceWords(dictionary, sentence));
        System.out.println(offReplaceWords(dictionary, sentence));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        return null;
    }






    public static String myReplaceWords(List<String> dictionary, String sentence) {
        String[] d = sentence.split(" ");
        // 如果继承词有许多可以形成它的词根，则用最短的词根替换它 = 先按长度排序
        dictionary.sort((o1, o2) -> o1.length() - o2.length());
        for (int i = 0; i < d.length; i++) {
            String dict = d[i];
            for (String diction : dictionary) {
                if (dict.startsWith(diction)) {
                    d[i] = diction;
                    break;
                }
            }
        }
        return String.join(" ", d);
    }

    /**
     * 官方解答：字典树
     * @param dictionary 字典
     * @param sentence 句子
     * @return 转词根句子
     */
    public static String offReplaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        // 每个单词执行一次，构造字典树
        for (String word : dictionary) {
            Trie cur = trie;
            // 单词内部根据char做循环, 构造该word的字典
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                // 不存在则put，否则直接返回
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            // 构造后以#表示单词结束
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    /**
     * 从字典树中找到最短的词根
     * @param word 要寻找的word
     * @param trie 字典树
     * @return 找word最短的词根
     */
    public static String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 循环中如果children包括 # 结尾符号，说明已经找到了词根root
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            // 如果执行中字典树都不包含word的下个字符，则字典中无此词根
            if (!cur.children.containsKey(c)) {
                return word;
            }
            // 存在, append到词根root中
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<Character, Trie>();
    }

}
