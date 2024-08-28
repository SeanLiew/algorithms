package leet.link;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-27 20:08
 */
public class CopyRandomList {
    Map<Node, Node> nodeCache = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!nodeCache.containsKey(head)) {
            Node headNew  = new Node(head.val);
            nodeCache.put(head, headNew);
            headNew.next = copyRandomList2(head.next);
            headNew.random  = copyRandomList2(head.random);
        }
        return nodeCache.get(head);
    }
    public Node copyRandomList(Node head) {
        Node newNodeHead = new Node(0);
        Node pointerNode = newNodeHead;

        Node copy = head;
        //每个节点对应的index-老的
        Map<Node, Integer> indexMapOld = new HashMap<>();
        //每个index对应的random-老的
        Map<Integer, Node> randomMapOld = new HashMap<>();

        //每个index对应的node-新的
        Map<Integer, Node> randomMapNew = new HashMap<>();
        int index = 0;
        while (copy != null) {
            Node temp = new Node(copy.val);
            pointerNode.next = temp;
            pointerNode = temp;
            randomMapNew.put(index, temp);
            indexMapOld.put(copy, index);
            randomMapOld.put(index++, copy.random);
            copy = copy.next;
        }
        //每个index对应的random的index
        Map<Integer, Integer> randomIndexMapOld = new HashMap<>();
        for (Map.Entry<Integer, Node> entry :  randomMapOld.entrySet()) {
            randomIndexMapOld.put(entry.getKey(), indexMapOld.get(entry.getValue()));
        }

        Node tempNode = newNodeHead.next;
        int tempIndex = 0;
        while (tempNode != null) {
            Integer randomIndex = randomIndexMapOld.get(tempIndex);
            if (randomIndex != null) {
                tempNode.random = randomMapNew.get(randomIndex);
            }
            tempIndex++;
            tempNode = tempNode.next;
        }
        return newNodeHead.next;
    }

    @Test
    public void test (){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node1.random = node4;
        node2.next = node3;
        node3.next = node4;
        node3.random = node2;

//        Node node = node1;
        Node node = copyRandomList2(node1);

        while(node != null){
            String print = node.val + "";
            if (node != null && node.random != null) {
                print += ",random:" + node.random.val;
            }
            System.out.println(print);
            node = node.next;
        }

    }
}
