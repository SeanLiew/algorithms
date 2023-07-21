package leet.tree;

import org.junit.Test;

/**
 * desc: 平衡二叉树
 * author: liuxiaozheng
 * time: 2020/6/24  10:08
 **/
public class BalanceTree {
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

        TreeNode rightNode11 = new TreeNode(6);
        rightNode1.right = rightNode11;

        TreeNode rightNode111 = new TreeNode(7);
        rightNode11.left = rightNode111;

        TreeNode rightNode112 = new TreeNode(8);
        rightNode11.left = rightNode112;



        System.out.println(isBalanced(treeNode1));
        System.out.println(isBalanced2(treeNode1));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int gap = height(1, root.left) - height(1, root.right);
        if (Math.abs(gap) < 2 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    private int height(int parentHeight, TreeNode root){
        if (root == null){
            return parentHeight;
        }
        int currentHeight = parentHeight + 1;
        if (root.left == null && root.right == null){
            return currentHeight;
        }
        int leftHeight = height(currentHeight, root.left);
        int rightHeight = height(currentHeight, root.right);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }









    public boolean isBalanced2(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced2(root.left) && isBalanced2(root.right)){
            return true;
        }


        return false;
    }


    public int height2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int height = 1;

        int leftHeight = height2(root.left);

        int rightHeight = height2(root.right);

        return height + Math.max(leftHeight, rightHeight);
    }
}
