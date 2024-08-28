package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-28 18:58
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            map.put(index++, cur);
            cur  = cur.next;
        }
        k = k % index;
        if (k == 0) {
            return head;
        }
        ListNode pre = map.get(index - k - 1);
        ListNode newHead = map.get(index - k);
        pre.next = null;
        ListNode last = map.get(index - 1);
        last.next = head;
        return newHead;
    }
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            index++;
            cur  = cur.next;
        }
        k = k % index;
        if (k == 0) {
            return head;
        }
        ListNode pre = null;
        ListNode newHead = null;
        ListNode last = null;
        ListNode cur2 = head;
        int i = 0;
        while (cur2 != null) {
            if (index - k == i + 1) {
                pre = cur2;
            }
            if (index - k == i) {
                newHead = cur2;
            }
            if (index == i + 1) {
                last = cur2;
            }
            i++;
            cur2  = cur2.next;
        }
        pre.next = null;
        last.next = head;
        return newHead;
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

        ListNode listNode = rotateRight2(first, 2);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

}
