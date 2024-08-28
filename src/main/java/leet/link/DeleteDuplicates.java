package leet.link;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                set.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre != null) {
            ListNode current = pre.next;
            if (current != null && set.contains(current.val)) {
                pre.next = current.next;
                continue;
            }
            pre = pre.next;
        }
        return dummyHead.next;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = this.deleteDuplicates2(node1);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
