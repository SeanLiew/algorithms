package leet.tree;

import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 20:22
 */
public class ReverseBinaryTree {

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


        TreeNode treeNode = mirrorTree(treeNode1);

        System.out.println(treeNode);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = root.right;

        root.right = mirrorTree(root.left);

        root.left = mirrorTree(right);

        return root;

    }
}
