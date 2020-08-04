package leet.stacks;

import java.util.Stack;

/**
 * desc: 最小的栈
 * author: liuxiaozheng
 * time: 2020/7/7  16:02
 **/
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stack_min;
    public MinStack() {
        stack = new Stack<>();
        stack_min = new Stack<>();
    }

    public void push(Integer x) {
        stack.push(x);
        if (stack_min.isEmpty() || x <= stack_min.peek()){
            stack_min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        Integer pop = stack.pop();
        if (pop.equals(stack_min.peek())){
            stack_min.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()){
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack_min.isEmpty()){
            return 0;
        }
        return stack_min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int min1 = minStack.getMin();
        System.out.println(min1);
        int min2 = minStack.getMin();
        System.out.println(min2);
        minStack.pop();
        int min3 = minStack.getMin();
        System.out.println(min3);


    }

}
