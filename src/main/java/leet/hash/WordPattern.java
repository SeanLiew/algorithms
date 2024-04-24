package leet.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-04-24 11:36
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        String[] arr = new String[26];
        Map<String, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (arr[index] == null) {
                arr[index] = split[i];
            } else {
                if (!arr[index].equals(split[i])) {
                    return false;
                }
            }
            if (stringMap.get(split[i]) == null) {
                stringMap.put(split[i], index);
            } else {
                if (stringMap.get(split[i]) != index) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1() {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }
}
