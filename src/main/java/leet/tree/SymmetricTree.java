package leet.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * desc: 对称二叉树
 * author: liuxiaozheng
 * time: 2020/6/19  17:31
 **/
public class SymmetricTree {
    @Test
    public void isSymmetric(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(3);
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(3);
        treeNode3.left = treeNode6;
        TreeNode treeNode7 = new TreeNode(4);
        treeNode3.right = treeNode7;


        System.out.println(isSymmetric2(treeNode1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null){
            return true;
        }
        if (leftNode == null || rightNode == null){
            return false;
        }
        if (leftNode.val != rightNode.val){
            return false;
        }
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(queue.size() > 0){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
