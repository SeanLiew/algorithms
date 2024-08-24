package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

public class DiameterOfBinaryTree {
    int record = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return record;
    }
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        record = 1 + Math.max(left, right);
        return Math.max(left, right);
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


        System.out.println(diameterOfBinaryTree(treeNode1));
    }
    @Test
    public void test2(){
        TreeNode treeNode1 = new TreeNode(3);
        System.out.println(diameterOfBinaryTree(treeNode1));
    }
    @Test
    public void test3(){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node2.left = node3;

        System.out.println(diameterOfBinaryTree(node1));
    }
}
