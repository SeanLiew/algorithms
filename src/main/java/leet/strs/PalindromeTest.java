package leet.strs;

import org.junit.Test;

import java.util.Stack;

/**
 * desc: 回文串
 * author: liuxiaozheng
 * time: 2020/7/1  10:59
 **/
public class PalindromeTest {
    @Test
    public void test(){
//        String strs = "A man, a plan, a canal: Panama";
        String strs = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(strs);
        System.out.println(result);

    }

    public boolean isPalindrome(String str) {
        if (str == null){
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            String thisStr = c + "";
            if (c >= 97 && c <= 122 || c >= 65 && c <= 90 || c >= 48 && c <= 57){
                if (stack.isEmpty()){
                    stack.push(thisStr);
                    continue;
                }
                String lastStr = stack.peek();
                if (lastStr.equalsIgnoreCase(thisStr)){
                    stack.pop();
                } else {
                    stack.push(thisStr);
                }
            }
        }
        return stack.isEmpty();
    }
}
