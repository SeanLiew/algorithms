package leet.link;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-28 20:22
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode next = pre.next;
        while (next != null && next.val < x) {
            next = next.next;
            pre = pre.next;
        }

        ListNode pre2 = next;
        while (pre2 != null) {
            ListNode temp = pre2.next;
            if (temp != null && temp.val < x && next.val >= x) {
                pre2.next = temp.next;
                temp.next = next;
                pre.next = temp;
                pre = temp;
                continue;
            }
            pre2 = pre2.next;
        }

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(2);
        third.next = forth;
        ListNode fifth = new ListNode(5);
        forth.next = fifth;
        ListNode node6 = new ListNode(2);
        fifth.next = node6;

        ListNode listNode = partition(first, 3);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
