package leet.stacks;

import org.junit.Test;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (stack.isEmpty()) {
                stack.push(str);
                continue;
            }
            if ("+-*/".contains(str)) {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                switch (str) {
                    case "+":
                        stack.push(String.valueOf(num2 + num1));
                        continue;
                    case "-":
                        stack.push(String.valueOf(num2 - num1));
                        continue;
                    case "*":
                        stack.push(String.valueOf(num2 * num1));
                        continue;
                    case "/":
                        stack.push(String.valueOf(num2 / num1));
                }
            } else {
                stack.push(str);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    @Test
    public void test(){
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

    }
}
