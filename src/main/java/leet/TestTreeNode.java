package leet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-05-09 14:53
 */
public class TestTreeNode {


    public TreeNode reverse (TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode poll = nodeQueue.poll();
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            poll.left = right;
            poll.right = left;
            if (left!= null) {
                nodeQueue.offer(left);
            }
            if (right != null) {
                nodeQueue.offer(right);
            }
        }
        return root;
    }

    @Test
    public void test () {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(4);
        list.add(6);
        System.out.println(list.subList(3, 3));
        System.out.println(list.size());
        System.out.println(list.subList(3, 6));

    }
}
