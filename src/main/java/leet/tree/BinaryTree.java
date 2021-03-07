package leet.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree {

    private Map<Integer, Integer> indexMap;


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int length = inorder.length;

        indexMap = new HashMap<>();

        for (int i=0; i < length; i++){
            indexMap.put(inorder[i], i);
        }


        return buildSubTree(preorder, inorder, 0, length -1, 0, length - 1);
    }


    //对于任意一颗树而言，前序遍历的形式总是
    //[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    //即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
    //[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]


    private TreeNode buildSubTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight,
                                  int inOrderLeft, int inOrderRight) {

        if (preOrderLeft > preOrderRight){
            return null;
        }

        //左序遍历，第一个节点未根节点
        int preOrderRoot = preorder[preOrderLeft];

        //中序遍历的根节点 index
        int inOrderRootIndex = indexMap.get(preOrderRoot);


        //左子树长度
        int leftLength = inOrderRootIndex - inOrderLeft;

        //根节点
        TreeNode root = new TreeNode(preOrderRoot);

        //左子树
        TreeNode leftTree = buildSubTree(preorder, inorder, preOrderLeft + 1, preOrderLeft + leftLength,
                inOrderLeft, inOrderRootIndex - 1);


        //右子树
        TreeNode rightTree = buildSubTree(preorder, inorder, preOrderLeft + 1 + leftLength,
                preOrderRight, inOrderRootIndex + 1, inOrderRight);


        root.left = leftTree;

        root.right = rightTree;


        return root;
    }




}
