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

    public static LinkNode reverseNode(LinkNode node){
        if (node == null){
            return null;
        }

        LinkNode first = null;
        LinkNode prev = null;

        boolean setFirst = false;
        while(true){
            LinkNode nextNode = node.next;
            if (nextNode == null){
                break;
            }
            node.next = nextNode.next;
            nextNode.next = node;
            if (prev == null){
                prev = node;
            } else {
                prev.next = nextNode;
            }
//            prev = node;
            node = node.next;

            if (!setFirst){
                first = nextNode;
                setFirst = true;
            }
        }
        return first;
    }

    static class LinkNode{
        private int value;
        LinkNode next;
        LinkNode(int value){
            this.value = value;
        }
    }
}

