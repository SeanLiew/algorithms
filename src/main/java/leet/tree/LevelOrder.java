package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * desc: 层次遍历
 * author: liuxiaozheng
 * time: 2020/6/22  15:31
 **/
public class LevelOrder {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        result.add(0, 1);
        result.add(0, 2);
        result.add(0, 3);
        System.out.println(GsonUtils.toJson(result));

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


        System.out.println(GsonUtils.toJson(levelOrderBottom(treeNode1)));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            List<TreeNode> subNode = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null){
                    subNode.add(poll.left);
                }
                if (poll.right != null){
                    subNode.add(poll.right);
                }
            }
            result.add(0, list);
            queue.addAll(subNode);
        }

        return result;
    }


}
