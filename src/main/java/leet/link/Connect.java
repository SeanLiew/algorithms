package leet.link;

import leet.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-10 19:10
 */
public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node pre = queue.poll();
            List<Node> list = new ArrayList<>();
            if (pre.left != null) {
                list.add(pre.left);
            }
            if (pre.right != null) {
                list.add(pre.right);
            }
            while (!queue.isEmpty()) {
                Node next = queue.poll();
                if (next.left != null) {
                    list.add(next.left);
                }
                if (next.right != null) {
                    list.add(next.right);
                }
                pre.next = next;
                pre = next;
            }
            queue.addAll(list);
        }
        return root;
    }
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Node> list = new ArrayList<>();
            int n = queue.size();
            Node last = null;
            for (int i = 0; i < n; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    list.add(poll.right);
                }
                if (i != 0) {
                    last.next = poll;
                }
                last = poll;
            }
            queue.addAll(list);
        }
        return root;
    }


    @Test
    public void test (){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;


        Node node = connect2(node1);

        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }

    }

}
