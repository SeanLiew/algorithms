package leet.link;

import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 17:37
 */
public class DeleteByVal {
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

        ListNode listNode = deleteNode(first, 5);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }


    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head.next;
        }
        //1-2-3-4
        ListNode cur = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while(cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                return head;
            }
            cur = cur.next;
            pre = pre.next;
        }

        return null;
    }
}
