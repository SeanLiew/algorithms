package leet.strs;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/11 10:24
 */
public class FirstUniqueChar {

    @Test
    public void test(){
        System.out.println(firstUniqChar("cc"));
        System.out.println(firstUniqChar("abbcc"));
        System.out.println(firstUniqChar("rtrs"));
        System.out.println(firstUniqChar("abc"));
        System.out.println(firstUniqChar("loveleetcode"));

    }


    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0){
            return ' ';
        }
        int resultIndex = -1;
        a : for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < s.length(); j++){
                if (i != j && s.charAt(i) == s.charAt(j)){
                    continue a;
                }
            }
            resultIndex = resultIndex == -1 ? i : Math.min(resultIndex, i);
        }
        if (resultIndex == -1){
            return ' ';
        }
        return s.charAt(resultIndex);
    }
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            boolean val = map.get(c) == null ? true : false;
            map.put(c, val);
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()){
            if (entry.getValue()){
                return entry.getKey();
            }
        }
        return ' ';
    }
}
