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
        int minDiff = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);





        return minDiff;
    }

    TreeNode treeNode1 = new TreeNode(3);
    public List<Integer> inOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;

        }
        return result;
    }

    @Test
    public void testMid(){
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

        List<Integer> integers = inOrderTraverse(treeNode1);
        System.out.println(JSON.toJSONString(integers));

    }
}
