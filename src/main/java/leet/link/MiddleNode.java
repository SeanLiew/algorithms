package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(index++, head);
            head = head.next;
        }
        int i = index / 2;
        return map.get(i);
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        ListNode listNode = this.middleNode(node1);

        if(listNode != null){
            System.out.println(listNode.val);
        }

    }
}
