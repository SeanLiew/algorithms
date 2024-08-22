package leet.link;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-22 23:40
 */
public class IsPalindromeTest {
    public boolean isPalindrome(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        String s1 = stringBuilder.toString();
        String s2 = stringBuilder.reverse().toString();
        return s1.equals(s2);
    }

    @Test
    public void test (){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(isPalindrome(node1));

    }
}
