package leet.link;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 相交链表
 * author: liuxiaozheng
 * time: 2020/7/8  14:28
 **/
public class IntersectionNode {
    @Test
    public void test(){

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node2.next = node3;


        ListNode intersectionNode = this.getIntersectionNode3(node2, node3);

        System.out.println(GsonUtils.toJson(intersectionNode));

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null){
            ListNode temp = headB;
            while(headB != null){
                if (headA == headB){
                    return headA;
                }
                headB = headB.next;
            }
            headB = temp;
            headA = headA.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int countEnd = 0;

        while(true){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            if (headA == null){
                headA = tempB;
                countEnd++;
            }
            if (headB == null){
                headB = tempA;
                countEnd++;
            }
            if (countEnd == 4){
                break;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        Map<ListNode, Boolean> map = new HashMap<>();

        while(headA != null){
            map.put(headA, true);
            headA = headA.next;
        }
        while(headB != null){
            if (map.get(headB) != null){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
