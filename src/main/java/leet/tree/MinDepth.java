package leet.tree;

import org.junit.Test;

/**
 * desc: 二叉树的最小深度
 * author: liuxiaozheng
 * time: 2020/6/24  11:03
 **/
public class MinDepth {
    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(9);
        TreeNode rightNode1 = new TreeNode(20);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(15);
        TreeNode leftNode12 = new TreeNode(7);
        rightNode1.left = leftNode11;
        rightNode1.right = leftNode12;

        System.out.println(minDepth(treeNode1));
    }
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null){
            minDepth =  Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null){
            minDepth =  Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }
//    public int minDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        return minHeight(0, root);
//
//    }
    private int minHeight(int parentHeight, TreeNode node){
        if (node == null){
            return parentHeight;
        }
        int currentHeight = parentHeight + 1;
        if (node.left == null && node.right == null){
            return currentHeight;
        }
        int leftHeight = minHeight(currentHeight, node.left);
        int rightHeight = minHeight(currentHeight, node.right);

        if (node.left == null || node.right == null){
            return leftHeight > rightHeight ? leftHeight : rightHeight;
        }
        return leftHeight > rightHeight ? rightHeight : leftHeight;
    }
}
