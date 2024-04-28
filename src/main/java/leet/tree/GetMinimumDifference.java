package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int minDiff = Integer.MAX_VALUE;
        int preValue = 0;
        boolean first = true;

        while (!stack.isEmpty()  || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (!first) {
                minDiff = Math.min(minDiff, Math.abs(preValue - cur.val));
            } {
                first = false;
            }
            preValue = cur.val;
            cur = cur.right;
        }
        return minDiff;
    }

    @Test
    public void test1(){
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(48);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode rightNode11 = new TreeNode(12);
        TreeNode rightNode12 = new TreeNode(49);
        rightNode1.left = rightNode11;
        rightNode1.right = rightNode12;

        System.out.println(getMinimumDifference(treeNode1));

    }
    @Test
    public void test2(){
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode leftNode1 = new TreeNode(1);
        treeNode1.left = leftNode1;

        System.out.println(getMinimumDifference(treeNode1));

    }
}
