package leet.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * desc: 最大深度
 * author: liuxiaozheng
 * time: 2020/6/22  14:53
 **/
public class MaxDepth {
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


        System.out.println(maxDepth(treeNode1));
        System.out.println(maxDepth2(treeNode1));
        System.out.println(maxDepth3(treeNode1));
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 1;
        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        if (leftDepth >= rightDepth){
            depth = depth + leftDepth;
        } else {
            depth = depth + rightDepth;
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode pop = queue.poll();
                if (pop.left != null){
                    queue.add(pop.left);
                }
                if (pop.right != null){
                    queue.add(pop.right);
                }
            }
            level++;
        }
        return level;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null){
            return 0;
        }
        int height = 1;

        int leftHeight = maxDepth3(root.left);

        int rightHeight = maxDepth3(root.right);

        return height + Math.max(leftHeight, rightHeight);
    }
}
