package leet.link;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/10  14:18
 **/
public class RemoveDuplicates {
    @Test
    public void test(){
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(1);
        ListNode node14 = new ListNode(1);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        ListNode listNode = this.deleteDuplicates(node11);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while (true){
            if (pointer == null || pointer.next == null){
                return head;
            }
            if (pointer.val == pointer.next.val){
                pointer.next = pointer.next.next;
                continue;
            }
            pointer = pointer.next;
        }
    }
}
