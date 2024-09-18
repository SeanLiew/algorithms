package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        if (root1 != null) {
            root.val = root1.val;
        }
        if (root2 != null) {
            root.val = root.val + root2.val;
        }
        root.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        root.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return root;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(1);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        leftNode1.left = new TreeNode(2);
        rightNode1.left = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(5);
        TreeNode leftNode2 = new TreeNode(2);
        TreeNode rightNode2 = new TreeNode(3);
        treeNode2.left = leftNode2;
        treeNode2.right = rightNode2;

        TreeNode treeNode = mergeTrees(treeNode1, treeNode2);

        System.out.println(GsonUtils.toJson(treeNode));
    }
}
