package leet.queue;

import java.util.Stack;

public class CQueue {

    Stack<Integer> a, b;

    public CQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (!b.isEmpty()){
            return b.pop();
        }
        if (a.isEmpty()){
            return -1;
        }
        while(!a.isEmpty()){
            Integer pop = a.pop();
            b.push(pop);
        }
        return b.pop();
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();

        queue.appendTail(1);
        queue.appendTail(2);

        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        System.out.println(queue.deleteHead());


    }
}
