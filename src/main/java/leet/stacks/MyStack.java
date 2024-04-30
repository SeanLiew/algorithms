package leet.stacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-04-30 09:48
 */
public class MyStack {
    List<Integer> list = new LinkedList<>();
    int top = -1;
    public MyStack() {

    }

    public void push(int x) {
        list.add(x);
        top++;
    }

    public int pop() {
        if (top < 0) {
            return -1;
        }
        Integer topVal = list.get(top);
        list.remove(top);
        top--;
        return topVal;

    }

    public int top() {
        if (top < 0) {
            return -1;
        }
        return list.get(top);
    }

    public boolean empty() {
        return top < 0;
    }

    @Test
    public void test() {

        MyStack stack = new MyStack();

        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        System.out.println(stack.top());
    }
}
