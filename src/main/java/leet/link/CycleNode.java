package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 重复链表
 * author: liuxiaozheng
 * time: 2020/7/7  14:35
 **/
public class CycleNode {
    @Test
    public void test(){
        System.out.println("123");

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        boolean b = this.hasCycle(node1);

        System.out.println(b);

    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowRunner = head;
        ListNode fastRunner = head.next;
        while (fastRunner != null && fastRunner.next != null && slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return slowRunner == fastRunner;
    }
}
