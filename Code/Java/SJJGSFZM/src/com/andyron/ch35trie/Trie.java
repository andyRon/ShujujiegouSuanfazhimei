package com.andyron.ch35trie;

/**
 * @author andyron
 **/
public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * 像Trie树中插入一个字符串
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在Trie树中查找一个字符串
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false;  // 不存在pattern
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) {
            return false;  // 不能完全匹配，只是前缀
        } else {
            return true;
        }
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        /**
         * 表示是否是最后一个标识位
         */
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }
}
