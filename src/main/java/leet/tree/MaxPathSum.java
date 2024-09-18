package leet.tree;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-12 20:10
 */
public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(maxGain(root.left), 0);
        int maxRight = Math.max(maxGain(root.right), 0);

        maxSum = Math.max(maxSum, root.val + maxLeft + maxRight);

        return Math.max(root.val + maxLeft,  root.val + maxRight);
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

        int val = maxPathSum(treeNode1);
        System.out.println(val);
    }
}
