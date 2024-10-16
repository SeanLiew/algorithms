package leet.tree;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-16 19:50
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid - 1);
        treeNode.right = helper(nums, mid + 1, right);
        return treeNode;
    }



    @Test
    public void test(){
        int[] arr = {1,2,3,5,6,7,8,9,10};

        TreeNode treeNode = sortedArrayToBST(arr);
        System.out.println(treeNode);
    }
}
