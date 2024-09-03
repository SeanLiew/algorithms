package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    int currentIndex;

    ListNode keyNode;
    Map<Integer, Integer> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        ListNode pre = new ListNode();
        pre.next = keyNode;
        ListNode cur = keyNode;
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        //挪到第一个
        cur.next = keyNode;
        keyNode = cur;

        return value;
    }

    public void put(int key, int value) {
        Integer val = map.get(key);
        //存在
        if (val != null) {
            map.put(key, value);

            ListNode pre = new ListNode();
            pre.next = keyNode;
            ListNode cur = keyNode;
            while (cur.val != key) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = cur.next;
            //挪到第一个
            cur.next = keyNode;
            keyNode = cur;
            return;
        }
        //容量超出
        if (currentIndex > capacity - 1) {
            ListNode pre = new ListNode();
            pre.next = keyNode;
            ListNode cur = keyNode;
            while (cur.next != null) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null;
            //去掉最后一个key
            map.remove(cur.val);
        } else {
            currentIndex++;
        }
        map.put(key, value);
        ListNode newKeyNode = new ListNode(key);
        newKeyNode.next = keyNode;
        keyNode = newKeyNode;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

}
