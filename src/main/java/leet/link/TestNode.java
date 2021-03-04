package leet.link;

import com.alibaba.fastjson.JSON;

/**
 * @Description:
 * @author: liuxiaozheng
 * @Created: 2020-05-25-20:51
 */
public class TestNode {
    public static void main(String[] args) {
        LinkNode first = new LinkNode(1);
        LinkNode second = new LinkNode(2);
        first.next = second;
        LinkNode third = new LinkNode(3);
        second.next = third;
        LinkNode forth = new LinkNode(4);
        third.next = forth;
        LinkNode fifth = new LinkNode(5);
        forth.next = fifth;

//        LinkNode result = reverseNode(first);
//        System.out.println(JSON.toJSON(result));
//        LinkNode result = reverse(first, third);
//        System.out.println(JSON.toJSON(result));
        LinkNode result = reverseGroup(first, 2);
        System.out.println(JSON.toJSON(result));

    }

    public static LinkNode reverseNode(LinkNode head){

        LinkNode pre = null, cur = head, next = null;

        while(cur != null){
            next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;
        }

        return pre;
    }

    static class LinkNode{
        private int value;
        LinkNode next;
        LinkNode(int value){
            this.value = value;
        }
    }


    private static LinkNode reverseGroup(LinkNode head, int k){

        LinkNode a = head, b = head;


        for (int i = 0; i < k; i++){
            if (b == null){
                return a;
            }
            b = b.next;
        }

        LinkNode newHead = reverse(a, b);

        LinkNode reverse2 = reverseGroup(b, k);

        a.next = reverse2;

        return newHead;
    }

    private static LinkNode reverse(LinkNode a, LinkNode b){
        LinkNode pre = null, cur = a, next = null;

        while(cur != b){
            next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;

        }
        return pre;
    }
}

