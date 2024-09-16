package leet.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = map.get(node);
        if (newNode == null) {
            newNode = new Node(node.val);
            List<Node> neighbors = new ArrayList<>();
            newNode.neighbors = neighbors;
            map.put(node, newNode);
            for (Node n : node.neighbors) {
                Node newNeighbor = cloneGraph(n);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return newNode;
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        List<Node> neighbors = new ArrayList<>();
        node1.neighbors = neighbors;
        Node node2 = new Node(2);
        neighbors.add(node2);
        Node node = cloneGraph(node1);
        System.out.println(node.val);
    }
}
