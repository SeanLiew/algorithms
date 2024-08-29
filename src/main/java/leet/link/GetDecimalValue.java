package leet.link;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-29 20:47
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    @Test
    public void test() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(0);
        first.next = second;
        ListNode third = new ListNode(1);
        second.next = third;
        ListNode forth = new ListNode(0);
        third.next = forth;
        ListNode fifth = new ListNode(1);
        forth.next = fifth;

        System.out.print(getDecimalValue(first));
    }
}
