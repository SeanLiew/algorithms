package leet.stacks;

import leet.tree.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * desc: 最小的栈
 * author: liuxiaozheng
 * time: 2020/7/7  16:02
 **/
public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public MinStack (){
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }


    public void push(Integer val){
        stack.push(val);

        if (minStack.isEmpty() || val < minStack.peek()){
            minStack.push(val);
        }
    }

    public Integer pop(){

        Integer pop = stack.pop();
        if (!minStack.isEmpty() && pop == minStack.peek()){
            minStack.pop();
        }
        return pop;
    }

    public Integer getMin(){
        return minStack.peek();
    }


    @Test
    public void test(){

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();

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


}
