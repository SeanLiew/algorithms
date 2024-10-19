package leet.stacks;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-17 21:18
 */
public class Calculate {

    //1-(1-(1+1-3)-2)
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int res = 0;
        int sign = 1;
        int i = 0;
        while (i < s.length()) {
            if (' ' == s.charAt(i)) {
                i++;
                continue;
            }
            if (s.charAt(i) == '+') {
                sign = stack.peek();
                i++;
                continue;
            }
            if (s.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(sign);
                i++;
                continue;
            }
            if (s.charAt(i) == ')') {
                stack.pop();
                i++;
                continue;
            }
            int cur = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                cur = 10 * cur + s.charAt(i) - '0';
                i++;
            }
            res = res + sign * cur;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(calculate("(6)-(8)-(7)+(1+(6))"));
        System.out.println(calculate("1-(1-(1+1-3)-2)"));

    }
}
