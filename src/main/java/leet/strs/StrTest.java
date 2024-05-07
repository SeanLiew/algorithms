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
        String hav = "abdf";
        String needle = "df";

        int i1 = hav.indexOf(needle);

        int i = this.strStr(hav, needle);

        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++)  {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
