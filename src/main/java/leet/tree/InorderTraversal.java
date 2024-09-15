package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while(root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.poll();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode leftNode1 = new TreeNode(4);
        TreeNode rightNode1 = new TreeNode(7);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(3);
        TreeNode leftNode12 = new TreeNode(5);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(2);
        leftNode11.left = leftNode111;


        System.out.println(GsonUtils.toJson(treeNode1));
        System.out.println(GsonUtils.toJson(inorderTraversal(treeNode1)));
    }
}
