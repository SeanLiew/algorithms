package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(digits, 0, map, res, stringBuilder);
        return res;
    }

    public void backtrack(String digits, int index, Map<Character, String> map, List<String> res, StringBuilder stringBuilder) {
        if (stringBuilder.length() == digits.length()) {
            res.add(stringBuilder.toString());
        } else {
            char c = digits.charAt(index);
            String str = map.get(c);
            for (int i = 0; i < str.length(); i++) {
                stringBuilder.append(str.charAt(i));
                backtrack(digits, index + 1, map, res, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }



    @Test
    public void test() {

        System.out.println(JSON.toJSONString(letterCombinations("234")));
    }
}
