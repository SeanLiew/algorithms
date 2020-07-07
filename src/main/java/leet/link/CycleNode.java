package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * desc:
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
//        node6.next = node3;

        boolean b = this.hasCycle(node1);

        System.out.println(b);

    }


    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        while(head != null){
            System.out.println(head.val);
            Integer val = map.get(head);
            if (val != null){
                return true;
            }
            map.put(head, head.val);
            head = head.next;
        }
        return false;
    }
}
