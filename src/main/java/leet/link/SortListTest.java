package leet.link;

import org.junit.Test;

public class SortListTest {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head, last = head;

        //先找到最后一个节点
        while(last != null && last.next != null){
            last = last.next;
        }
        while (head != last) {
            while (current.next != null) {
                if (current.val > current.next.val) {
                    //更换val
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
                //最后节点前进一个
                if (current.next == last) {
                    last = current;
                    break;
                }
                current = current.next;
            }
            current = head;
        }
        return head;
    }
    @Test
    public void test (){
        ListNode first = new ListNode(6);
        ListNode second = new ListNode(4);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode fourth = new ListNode(5);
        third.next = fourth;

        ListNode print = first;

        while(print != null){
            System.out.print(print.val + "->");
            print = print.next;
        }

        first = sortList(first);

        System.out.println("--------");

        while(first != null){
            System.out.print(first.val + "->");
            first = first.next;
        }

    }
}
