package leet.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) {
            return false;
        }
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = map.get(c);
            if (count == null || count == 0) {
                return false;
            } else {
                map.put(c, count - 1);
            }
        }
        return true;
    }


    @Test
    public void test2(){
        System.out.println(canConstruct("abc", "ahbgdc"));
        System.out.println(canConstruct("aac", "ac"));

    }
}
