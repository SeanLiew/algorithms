package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> average = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum = sum + poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right!= null) {
                    queue.offer(poll.right);
                }
            }
            average.add(sum / size);
        }
        return average;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(2);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(4);
        TreeNode leftNode12 = new TreeNode(5);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(6);
        leftNode11.left = leftNode111;


        System.out.println(GsonUtils.toJson(averageOfLevels(treeNode1)));
    }
}
