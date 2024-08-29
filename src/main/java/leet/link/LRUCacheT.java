package leet.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-29 19:55
 */
public class LRUCacheT {
    int capacity;
    int currentIndex;

    DLinkedNode head;

    DLinkedNode tail;

    Map<Integer, DLinkedNode> map = new HashMap<>();

    public LRUCacheT(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        //挪到第一个
        toHead(node);

        return node.value;
    }

    private void toHead (DLinkedNode node) {
        if (node == head) {
            return;
        }
        DLinkedNode pre = node.previous;
        DLinkedNode next = node.next;
        pre.next = next;
        if (next != null) {
            next.previous = pre;
        }

        node.previous = null;
        //挪到第一个
        node.next = head;
        head.previous = node;
        head = node;
        //tail
        if (node == tail) {
            tail = pre;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        //存在
        if (node != null) {
            node.value = value;
            //挪到第一个
            toHead(node);
            return;
        }
        //放到头部
        DLinkedNode newNode = new DLinkedNode(key, value);
        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        }
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
        map.put(key, newNode);
        //容量超出
        if (currentIndex > capacity - 1) {
            //去掉最后一个key
            DLinkedNode pre = tail.previous;
            pre.next = null;
            map.remove(tail.key);
            tail = pre;
        } else {
            currentIndex++;
        }
    }

    public static void main(String[] args) {
        LRUCacheT lRUCache = new LRUCacheT(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(3, 4);
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
