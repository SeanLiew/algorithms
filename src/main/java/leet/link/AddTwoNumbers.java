package leet.link;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-27 09:59
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();
        ListNode head = node;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0 ) {
            int n1 = 0;
            int n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int sum = carry + n1 + n2;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            node.next = temp;
            node = temp;
        }
        return head.next;
    }

    @Test
    public void test (){
        ListNode first1 = new ListNode(1);
        ListNode third1 = new ListNode(3);
        first1.next = third1;
        ListNode forth1 = new ListNode(9);
        third1.next = forth1;

        ListNode first2 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        first2.next = second2;
        ListNode third2 = new ListNode(3);
        second2.next = third2;
        ListNode forth2 = new ListNode(4);
        third2.next = forth2;

        ListNode listNode = addTwoNumbers(first1, first2);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }
}
