package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {

    private Map<Integer, Integer> indexMap = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for (int i = 0 ; i < length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTreeSub(inorder, 0, length - 1, postorder, 0, length - 1);
    }
    public TreeNode buildTreeSub(int[] inorder, int inorderLeft, int inorderRight, int[] postorder, int postorderLeft, int postorderRight) {
        //根节点
        TreeNode root = new TreeNode(postorder[postorderRight]);
        int inorderIndex = indexMap.get(postorder[postorderRight]);

        //左节点长度
        int leftLength = inorderIndex - inorderLeft;
        if (leftLength > 0) {
            //左节点
            TreeNode leftNode = buildTreeSub(inorder, inorderLeft, inorderIndex - 1, postorder, postorderLeft, postorderLeft + leftLength - 1);
            root.left = leftNode;
        }
        if (inorderIndex < inorderRight) {
            //左节点
            TreeNode rightNode = buildTreeSub(inorder, inorderIndex + 1, inorderRight, postorder, postorderLeft + leftLength, postorderRight - 1);
            root.right = rightNode;
        }
        return root;
    }

    @Test
    public void test(){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(GsonUtils.toJson(treeNode));
    }

}
