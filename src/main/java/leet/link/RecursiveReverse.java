package leet.link;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 16:09
 */
public class RecursiveReverse {

    @Test
    public void test (){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(4);
        third.next = forth;
        ListNode fifth = new ListNode(5);
        forth.next = fifth;

//        ListNode listNode = reverseNodeN(first, 3);
        ListNode listNode = reverseBetween(first, 2, 3);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }


    public ListNode reverseNode2(ListNode head){
        if (head.next == null){
            return head;
        }

        ListNode lastNode = reverseNode2(head.next);

        head.next.next = head;

        head.next = null;


        return lastNode;
    }

    private ListNode successor = null;


    public ListNode reverseNodeN(ListNode head, int n){
        if (n == 1){
            successor = head.next;
            return head;
        }

        ListNode lastNode = reverseNodeN(head.next, n-1);

        head.next.next = head;

        head.next = successor;


        return lastNode;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1){
            return reverseNodeN(head, n);
        }

        head.next = reverseBetween(head.next, m-1, n-1);


        return head;
    }

}
