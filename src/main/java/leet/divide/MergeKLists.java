package leet.divide;

import leet.link.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-17 20:53
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode list1 = null;
        ListNode list2 = null;
        //合并
        if (lists.length == 2) {
            list1 = lists[0];
            list2 = lists[1];

        } else {
            //拆分
            int i = lists.length / 2;
            ListNode[] arr1 = Arrays.copyOfRange(lists, 0, i);
            ListNode[] arr2 = Arrays.copyOfRange(lists, i, lists.length);
            list1 = mergeKLists(arr1);
            list2 = mergeKLists(arr2);
        }
        ListNode res = new ListNode(0);
        ListNode current = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = (list1 == null ? list2 : list1);
        return res.next;
    }

    @Test
    public void test (){
        ListNode first = new ListNode(4);
        ListNode second = new ListNode(5);
        first.next = second;
        ListNode third = new ListNode(7);
        second.next = third;
        ListNode fourth = new ListNode(8);
        third.next = fourth;
        ListNode print = first;

        while(print != null){
            System.out.print(print.val + "->");
            print = print.next;
        }

        ListNode first2 = new ListNode(2);
        ListNode second2 = new ListNode(3);
        first2.next = second2;

        ListNode first3 = new ListNode(6);
        ListNode second3 = new ListNode(9);
        first3.next = second3;


        ListNode[] arr = {first, first2, first3};
        first = mergeKLists(arr);

        System.out.println("--------");

        while(first != null){
            System.out.print(first.val + "->");
            first = first.next;
        }

    }
}
