package leet.tree;


import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/6/1  15:41
 **/
public class TwoTree {

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(2);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode treeNode2 = new TreeNode(3);
        TreeNode leftNode2 = new TreeNode(1);
        TreeNode rightNode2 = new TreeNode(2);
        treeNode2.left = leftNode2;
        treeNode2.right = rightNode2;


        System.out.println(isSameTree(treeNode1,treeNode2 ));
    }
    @Test
    public void isSymmetric(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.right = treeNode5;


        System.out.println(isSymmetric(treeNode1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.right == null && root.left == null){
            return true;
        }
        if (root.right == null || root.left == null){
            return false;
        }
        if (root.right.val != root.left.val){
            return false;
        }
        return isSymmetric(root.right) && isSymmetric(root.left);
    }
}
