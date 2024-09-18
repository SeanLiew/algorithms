package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-12 20:57
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean left = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (left) {
                    list.add(poll.val);
                } else {
                    list.add(0, poll.val);
                }
            }
            result.add(list);
            left = !left;
        }
        return result;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode rightNode1 = new TreeNode(5);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(3);
        TreeNode leftNode12 = new TreeNode(4);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(6);
        rightNode1.left = leftNode111;

        System.out.println(JSON.toJSONString(zigzagLevelOrder(treeNode1)));
    }
}
