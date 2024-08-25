package leet.stacks;

import leet.tree.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * desc: 最小的栈
 * author: liuxiaozheng
 * time: 2020/7/7  16:02
 **/
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

    }

    public void pop() {
        Integer peek = stack.peek();
        stack.pop();
        if (peek != null && peek.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }


    @Test
    public void test(){

        MinStack minStack = new MinStack();

        minStack.push(9);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(4);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }

//        '('，')'，'{'，'}'，'['，']'
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character sym = map.get(s.charAt(i));
            if (!stack.isEmpty() && stack.peek().equals(sym)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (map.containsKey(peek) && map.get(peek) == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid(){

        System.out.println(isValid("[]{()}"));
        System.out.println(isValid("[]{())}"));
        System.out.println(isValid("[]{)(}"));

    }


}
