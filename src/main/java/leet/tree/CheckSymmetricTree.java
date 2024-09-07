package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CheckSymmetricTree {
    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isChildSymmetric(root.left, root.right);
    }
    private boolean isChildSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isChildSymmetric(left.left, right.right) && isChildSymmetric(left.right, right.left);
    }
    public boolean checkSymmetricTree2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);

            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }



    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(1);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        leftNode1.left = new TreeNode(2);
        rightNode1.left = new TreeNode(2);

        System.out.println(checkSymmetricTree2(treeNode1));
    }
}
