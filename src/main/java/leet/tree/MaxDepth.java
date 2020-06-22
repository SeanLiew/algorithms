package leet.tree;

import org.junit.Test;

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
}
