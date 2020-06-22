package leet.tree;


import org.junit.Test;

/**
 * desc: 相同二叉树
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

}
