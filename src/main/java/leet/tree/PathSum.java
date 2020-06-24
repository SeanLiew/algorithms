package leet.tree;

import org.junit.Test;

/**
 * desc: 路径总和
 * author: liuxiaozheng
 * time: 2020/6/24  13:50
 **/
public class PathSum {
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



        System.out.println(hasPathSum(treeNode1, 5));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        sum = sum - root.val;
        if (root.left == null && root.right == null){
            return (sum == 0);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null){
//            return false;
//        }
//        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//
//        queue.add(new Pair<>(root, root.val));
//
//        while(!queue.isEmpty()){
//            Queue<Pair<TreeNode, Integer>> tempQueue = new LinkedList<>();
//            while(!queue.isEmpty()){
//                Pair<TreeNode, Integer> pair = queue.poll();
//                if (pair.getValue() == sum && pair.getKey().left == null && pair.getKey().right == null){
//                    return true;
//                }
//                if ( pair.getKey().left != null){
//                    tempQueue.add(new Pair<>(pair.getKey().left, pair.getValue() + pair.getKey().left.val));
//                }
//                if (pair.getKey().right != null){
//                    tempQueue.add(new Pair<>(pair.getKey().right, pair.getValue() + pair.getKey().right.val));
//                }
//            }
//            queue.addAll(tempQueue);
//        }
//        return false;
//    }
}
