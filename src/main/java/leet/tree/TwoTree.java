package leet.tree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }



    @Test
    public void testPreorderTraversal(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode rightNode1 = new TreeNode(3);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode treeNode2 = new TreeNode(4);
        TreeNode leftNode2 = new TreeNode(5);
        TreeNode rightNode2 = new TreeNode(6);
        treeNode2.left = leftNode2;
        treeNode2.right = rightNode2;

        leftNode1.left = treeNode2;

        System.out.println(preorderTraversal(treeNode1));
        System.out.println(inorderTraversal(treeNode1));
        System.out.println(postorderTraversal(treeNode1));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.add(root.val);
            List<Integer> left = preorderTraversal(root.left);
            if (left.size() > 0){
                result.addAll(left);
            }
            List<Integer> right = preorderTraversal(root.right);
            if (right.size() > 0){
                result.addAll(right);
            }

        }
        return result;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null){
            List<Integer> left = inorderTraversal(root.left);
            if (left.size() > 0){
                result.addAll(left);
            }
            result.add(root.val);
            List<Integer> right = inorderTraversal(root.right);
            if (right.size() > 0){
                result.addAll(right);
            }

        }
        return result;

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null){
            List<Integer> left = postorderTraversal(root.left);
            if (left.size() > 0){
                result.addAll(left);
            }
            List<Integer> right = postorderTraversal(root.right);
            if (right.size() > 0){
                result.addAll(right);
            }
            result.add(root.val);

        }
        return result;

    }

    @Test
    public void testReverseBits(){

        System.out.println(reverseBits(255));
    }
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 1; i <= 8;i++){
            rev = (rev << 1) | (n & 1);
            n >>>= 1;
            System.out.println(n);

        }
        return rev;
    }

    @Test
    public void testHammingWeight(){

        System.out.println(hammingWeight(2147483645));
    }
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0){
            result += (n & 1);
            n >>>= 1;

        }
        return result;
    }

}
