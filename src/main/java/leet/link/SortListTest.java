package leet.link;

import org.junit.Test;

public class SortListTest {
    public ListNode sortList2(ListNode head) {
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
    public void test2 (){
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

        first = sortList2(first);

        System.out.println("--------");

        while(first != null){
            System.out.print(first.val + "->");
            first = first.next;
        }

    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        //合并
        ListNode current = new ListNode(0);
        ListNode res = current;

        while (left != null && right != null) {
            if ( right.val < left.val) {
                current.next = right;
                right = right.next;
            }else {
                current.next = left;
                left = left.next;
            }
            current = current.next;
        }
        current.next = left != null ? left : right;
        return res.next;
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
