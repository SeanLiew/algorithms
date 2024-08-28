package leet.link;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-27 21:09
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode();
        ListNode dummyHead = pre;
        pre.next = head;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode current = pre.next;
        ListNode next = null;
        for (int i = left; i < right; i++) {
            next = current.next;
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

    @Test
    public void test (){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseBetween(node1, 1, 3);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }
}
