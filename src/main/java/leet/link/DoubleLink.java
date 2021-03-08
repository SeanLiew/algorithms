package leet.link;

import org.junit.Test;

import java.util.List;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 18:12
 */
public class DoubleLink {
    @Test
    public void test (){
        ListNode first1 = new ListNode(1);
        ListNode third1 = new ListNode(3);
        first1.next = third1;
        ListNode forth1 = new ListNode(4);
        third1.next = forth1;

        ListNode first2 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        first2.next = second2;
        ListNode third2 = new ListNode(3);
        second2.next = third2;
        ListNode forth2 = new ListNode(4);
        third2.next = forth2;

        ListNode listNode = mergeTwoLists(first1, first2);

        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = l1;

        ListNode cur = dummyHead;

        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;

        return dummyHead.next;
    }
}
