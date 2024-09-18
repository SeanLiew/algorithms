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
 * @date 2024-09-12 20:18
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        while (!queue.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    tempList.add(poll.left);
                }
                if (poll.right != null) {
                    tempList.add(poll.right);
                }
            }
            queue.addAll(tempList);
            if (tempList.size() > 0) {
                int i = tempList.size() - 1;
                result.add(tempList.get(i).val);
            }
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

        System.out.println(JSON.toJSONString(rightSideView(treeNode1)));
    }
}
