package leet.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-12 19:48
 */
public class LowestCommonAncestor {

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            visited.add(p);
            p = parent.get(p);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parent.get(q);
        }

        return null;
    }
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
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
        rightNode1.left = leftNode111;

        TreeNode treeNode = lowestCommonAncestor(treeNode1, treeNode1, leftNode11);
        System.out.println(treeNode.val);
    }
}
