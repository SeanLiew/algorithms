package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-11 19:07
 */
public class Flatten {
    public void flatten(TreeNode root) {
        flattenSub(root);
    }
    public TreeNode flattenSub(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        TreeNode newLeft = flattenSub(left);
        if (newLeft != null) {
            root.right = newLeft;
        }
        while (newLeft != null && newLeft.right != null) {
            newLeft = newLeft.right;
        }
        TreeNode newRight = flattenSub(right);
        if (newRight != null) {
            if (newLeft != null) {
                newLeft.right = newRight;
            } else {
                root.right = newRight;
            }
        }
        return root;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode rightNode1 = new TreeNode(5);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(3);
        TreeNode leftNode12 = new TreeNode(4);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(6);
        rightNode1.right = leftNode111;

        System.out.println(JSON.toJSONString(treeNode1));

        flatten(treeNode1);
        while (treeNode1 != null) {
            System.out.print(treeNode1.val + "->");
            treeNode1 = treeNode1.right;
        }
    }

}
