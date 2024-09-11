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
 * @date 2024-09-11 19:40
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            TreeNode poll = queue.poll();
            if (poll.left == null && poll.right == null) {
                sum += poll.val;
            }

            if (poll.left != null) {
                poll.left.val += poll.val * 10;
                list.add(poll.left);
            }

            if (poll.right != null) {
                poll.right.val += poll.val * 10;
                list.add(poll.right);
            }
            queue.addAll(list);
        }
        return sum;
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
//
        TreeNode leftNode111 = new TreeNode(6);
        rightNode1.right = leftNode111;

        System.out.println(sumNumbers(treeNode1));
    }
}
