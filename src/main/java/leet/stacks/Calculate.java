package leet.stacks;

import leet.divide.ConstructFourTree;
import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-17 21:18
 */
public class Calculate {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();

        Integer result = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.charAt(i) + "";
            if (" ".equals(str)) {
                continue;
            }
            String peek = stack.peek();

        }


        return result;

    }

    @Test
    public void test() {

        int calculate = calculate("3-(1+1)");
        System.out.println(calculate);

    }
}
