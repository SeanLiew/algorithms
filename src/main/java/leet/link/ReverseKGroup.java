package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-29 20:43
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode current = pre.next;
        ListNode next = null;
        for (int i = 0; i < length/k; i++) {
            for (int j = 1; j < k; j++) {
                next = current.next;
                current.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = current;
            current = pre.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(4);
        third.next = forth;
        ListNode fifth = new ListNode(5);
        forth.next = fifth;

        ListNode listNode = reverseKGroup(first, 3);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
