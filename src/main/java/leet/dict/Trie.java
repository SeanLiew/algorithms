package leet.dict;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-25 21:21
 */
public class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int n = c - 'a';
            if (node.children[n] == null) {
                node.children[n] = new Trie();
            }
            node = node.children[n];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int n = c - 'a';
            if (node.children[n] == null) {
                return null;
            }
            node = node.children[n];
        }
        return node;
    }

    @Test
    public void test() {
        Trie node = new Trie();
        node.insert("apple");
        System.out.println(node.search("apple"));
        System.out.println(node.search("app"));
        System.out.println(node.startsWith("app"));
        node.insert("app");
        System.out.println(node.search("app"));
    }
}
