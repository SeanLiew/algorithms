package leet.link;

import org.junit.Test;

public class ListNodeTest {

    @Test
    public void testRemoveElements (){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(2);
        third.next = forth;
        ListNode fifth = new ListNode(5);
        forth.next = fifth;

//        while(first != null){
//            System.out.print(first.val + "->");
//            first = first.next;
//        }

        first = removeElements(first, 2);

        while(first != null){
            System.out.print(first.val + "->");
            first = first.next;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode prev = tempHead;
        while (head != null){
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                prev = prev.next;
            }
        }
        return tempHead.next;
    }

}
