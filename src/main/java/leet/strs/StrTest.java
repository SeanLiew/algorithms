package leet.strs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2019/12/19  14:57
 **/
public class StrTest {

    @Test
    public void test(){
        String[] strs = {"aa", "a"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        if (strs.length == 0){
            return result.toString();
        }

        String firstStr = strs[0];

        if (strs.length == 1){
            return firstStr;
        }

        for (int i=0; i < firstStr.length(); i++){
            char firstStrChar = firstStr.charAt(i);
            for (int j=1; j <  strs.length; j++){
                String otherStr = strs[j];
                if (otherStr.length() < i + 1){
                    return result.toString();
                }
                if (otherStr.charAt(i) != firstStrChar){
                    return result.toString();
                }
            }
            result = result.append(firstStrChar);
        }
        return result.toString();
    }

    @Test
    public void testValid(){
        String str = "()[]{}";
        boolean valid = isValid(str);
        System.out.println(valid);

    }

    private boolean isValid(String str){

        Map<Character, Character> params = new HashMap<>();
        params.put('[', ']');
        params.put('{', '}');
        params.put('(', ')');
        params.put(']', '[');
        params.put('}', '{');
        params.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i < str.length(); i++){
            char thisChar = str.charAt(i);
            if (stack.isEmpty()){
                stack.push(thisChar);
            }
            else {
                Character thisPart = params.get(thisChar);

                char lastChar = stack.peek();

                if (thisPart.equals(lastChar)){
                    stack.pop();
                } else {
                    stack.push(thisChar);
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void testSubStr(){
        String hav = "df";
        String needle = "df";

        int i1 = hav.indexOf(needle);

        int i = this.strStr(hav, needle);

        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null){
            return -1;
        }

        if (needle == null){
            return 0;
        }

        int length = needle.length();

        if (haystack.length() < length){
            return -1;
        }

        for (int i=0; i <= haystack.length() - length; i++){
            String sub = haystack.substring(i, i + length);
            if (needle.equals(sub)){
                return i;
            }
        }

        return -1;
    }

}
