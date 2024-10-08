package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int index = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            index++;
            cur  = cur.next;
        }
        ListNode pre = null;
        ListNode cur2 = dummy;
        int i = 0;
        while (cur2 != null) {
            if (index - n == i + 1) {
                pre = cur2;
            }
            i++;
            cur2  = cur2.next;
        }
        ListNode current = pre.next;
        pre.next = current.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        int index = 0;
        while (cur != null) {
            map.put(index++, cur);
            cur = cur.next;
        }

        ListNode pre = map.get(index - n - 1);
        if (pre != null) {
            ListNode next = pre.next;
            if (next != null) {
                pre.next = next.next;
            } else {
                pre.next = null;
            }
        }

        return dummyHead.next;
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

        ListNode listNode = removeNthFromEnd(first, 1);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
