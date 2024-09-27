package leet.dict;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-26 18:37
 */
public class WordDictionary {
    WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary wordDictionary = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean result = false;
                for (WordDictionary node : wordDictionary.children) {
                    if (node != null && node.search(word.substring(i + 1))) {
                        result = true;
                    }
                }
                return result;
            } else {
                int index = c - 'a';
                if (wordDictionary.children[index] == null) {
                    return false;
                }
                wordDictionary = wordDictionary.children[index];
            }
        }
        return wordDictionary.isEnd;
    }

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));

    }
    @Test
    public void test2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("pad"));

    }
}
