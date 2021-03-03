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

        LinkNode result = reverseNode(first);
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

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}

