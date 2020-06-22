package leet.tree;

import org.junit.Test;

/**
 * desc: 数组转二叉树
 * author: liuxiaozheng
 * time: 2020/6/22  16:54
 **/
public class ArrayToTree {
    @Test
    public void test(){
        int[] arr = {1,2,3,5,6,7,8,9,10};


        System.out.println(sortedArrayToBST(arr));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0, nums.length - 1);

    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        int nodeVal = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[nodeVal]);
        treeNode.left = helper(nums, left, nodeVal - 1);
        treeNode.right = helper(nums, nodeVal + 1, right);
        return treeNode;
    }
}
