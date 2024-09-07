package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BuildTree {
    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        //根节点在中序遍历数组中的下标
        int rootIndexInOrder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                rootIndexInOrder = i;
                break;
            }
        }
        //左节点的长度
        int leftLength = 0;
        if (rootIndexInOrder > 0) {
            int[] leftInOrderArr = Arrays.copyOfRange(inorder, 0, rootIndexInOrder);
            leftLength = leftInOrderArr.length;
            int[] leftPreOrderArr = Arrays.copyOfRange(preorder, 1, leftLength + 1);
            root.left = buildTree(leftPreOrderArr, leftInOrderArr);
        }
        //右节点
        if (leftLength + 1 < preorder.length) {
            int[] rightPreOrderArr = Arrays.copyOfRange(preorder, leftLength + 1, preorder.length);
            int[] rightInOrderArr = Arrays.copyOfRange(inorder, leftLength + 1, preorder.length);
            root.right = buildTree(rightPreOrderArr, rightInOrderArr);
        }
        return root;
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        //根节点在中序遍历数组中的下标
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeSub(preorder, 0, length - 1, inorder, 0, length - 1);
    }
    public TreeNode buildTreeSub(int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inorderRight) {
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int rootIndexInOrder = indexMap.get(preorder[preorderLeft]);
        int leftCount = 0;
        if (rootIndexInOrder > inorderLeft) {
            //左节点
            leftCount = rootIndexInOrder - inorderLeft;
            TreeNode leftNode = buildTreeSub(preorder, preorderLeft + 1, preorderLeft + leftCount, inorder, inorderLeft, rootIndexInOrder - 1);
            root.left = leftNode;
        }
        if (inorderRight > rootIndexInOrder) {
            //右节点
            int rightCount = inorderRight - rootIndexInOrder;
            TreeNode rightNode = buildTreeSub(preorder, preorderLeft + leftCount + 1, preorderRight, inorder, rootIndexInOrder + 1, inorderRight);
            root.right = rightNode;
        }
        return root;
    }

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    @Test
    public void test(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree3(preorder, inorder);
        System.out.println(GsonUtils.toJson(treeNode));
    }



}
