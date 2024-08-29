package leet.link;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-29 20:02
 */
public class DLinkedNode {
    int key;
    int value;

    DLinkedNode previous;

    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
