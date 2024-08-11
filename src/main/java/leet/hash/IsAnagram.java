package leet.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = toMap(s);
        Map<Character, Integer> map2 = toMap(t);

        for (Character c : map1.keySet()) {
            Integer num1 = map1.get(c);
            Integer num2 = map2.get(c);
            if (!num1.equals(num2)) {
                return false;
            }
        }
        for (Character c : map2.keySet()) {
            Integer num2 = map2.get(c);
            Integer num1 = map1.get(c);
            if (!num2.equals(num1)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> toMap (String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer num = map.get(c);
            if  (num == null) {
                num = 1;
            } else {
                num++;
            }
            map.put(c, num);
        }
        return map;
    }

    @Test
    public void test1() {
        System.out.println(isAnagram("abba", "dog cat cat dog"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
