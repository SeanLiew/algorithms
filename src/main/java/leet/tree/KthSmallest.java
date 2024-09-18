package leet.tree;

import com.alibaba.fastjson.JSON;
import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        bst(root, result);
        Collections.sort(result);
        return result.get(k - 1);
    }
    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            k--;
            root = queue.poll();
            if (k == 0) {
                break;
            }
            root = root.right;
        }

        return root.val;

    }


    private List<Integer> bst(TreeNode root, List<Integer> result){
        if (root == null) {
            return result;
        }
        result.add(root.val);
        bst(root.left, result);
        bst(root.right, result);
        return result;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(6);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(4);
        TreeNode leftNode12 = new TreeNode(8);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(5);
        leftNode11.left = leftNode111;


        System.out.println(GsonUtils.toJson(kthSmallest2(treeNode1, 3)));
    }
}
