package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-23 00:36
 */
public class PostorderTest {
    public List<Integer> postorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> left = postorder(root.left);
        if (left != null) {
            list.addAll(left);
        }
        List<Integer> right = postorder(root.right);
        if (right != null) {
            list.addAll(right);
        }
        list.add(root.val);
        return list;
    }

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


        List<Integer> postorder = postorder(treeNode1);
        System.out.println(JSON.toJSONString(postorder));

    }

}
