package leet.link;

import com.alibaba.fastjson.JSON;

public class ReverseLink {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(4);
        third.next = forth;
        ListNode fifth = new ListNode(5);
        forth.next = fifth;

//        ListNode result = reverseNode(first);
//        System.out.println(JSON.toJSON(result));
//        ListNode result = reverse(first, third);
//        System.out.println(JSON.toJSON(result));
        ListNode listNode = reverseBetween(first, 2, 3);
        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }

    public static int[] reversePrint(ListNode head) {
        int length = 0;

        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }

        int[] result = new int[length];
        while(head != null){
            result[--length] = head.val;
            head = head.next;
        }
        return result;

    }

    public static ListNode reverseNode(ListNode head){

        ListNode pre = null, cur = head, next = null;

        while(cur != null){
            next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;
        }

        return pre;
    }


    private static ListNode reverseGroup(ListNode head, int k){

        ListNode a = head, b = head;


        for (int i = 0; i < k; i++){
            if (b == null){
                return a;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);

        ListNode reverse2 = reverseGroup(b, k);

        a.next = reverse2;

        return newHead;
    }

    private static ListNode reverse(ListNode a, ListNode b){
        ListNode pre = null, cur = a, next = null;

        while(cur != b){
            next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;

        }
        return pre;
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for (int i=0; i<m-1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = null;
        for (int i=0; i<n-m; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyHead.next;



    }

}
