package leet.tree;

import leet.utils.GsonUtils;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/12 15:06
 */
public class KthLargest {
    @Test
    public void test(){
        TreeNode fif = new TreeNode(5);
        TreeNode thr = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        fif.left = thr;
        fif.right = six;

        TreeNode sec = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        thr.left = sec;
        thr.right = four;
        TreeNode fir = new TreeNode(1);
        sec.left = fir;

        System.out.println(kthLargest(fif, 2));
//        System.out.println(kthLargest(treeNode1, 3));
    }

    public int kthLargest(TreeNode root, int k) {
        index = k;
        maxToMin(root);
        return result;
    }

    private int index = 0;
    private int result = 0;

    public void maxToMin(TreeNode root) {
        if (root != null){
            maxToMin(root.right);
            if (--index == 0){
                result = root.val;
            }
            System.out.println(root.val + "->");
            maxToMin(root.left);

        }
    }
}