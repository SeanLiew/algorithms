package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTree {


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


        List<List<Integer>> lists = levelOrder2(treeNode1);

        System.out.println(JSON.toJSONString(lists));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> curList = new ArrayList<>();
        curList.add(root.val);

        List<List<Integer>> result = new ArrayList<>();
        result.add(curList);

        List<List<Integer>> leftSub = levelOrder(root.left);

        List<List<Integer>> rightSub = levelOrder(root.right);

        int maxSize = 0;
        if (leftSub != null && leftSub.size() > maxSize){
            maxSize = leftSub.size();
        }
        if (rightSub != null && rightSub.size() > maxSize){
            maxSize = rightSub.size();
        }

        for (int i = 0; i < maxSize; i++){
            List<Integer> subList = new ArrayList<>();
            if (leftSub != null && leftSub.size() > i){
                subList.addAll(leftSub.get(i));
            }
            if (rightSub != null && rightSub.size() > i){
                subList.addAll(rightSub.get(i));
            }
            result.add(subList);
        }

        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }

        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> temList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode last = queue.remove();
                temList.add(last.val);
                if (last.left != null){
                    queue.add(last.left);
                }
                if (last.right != null){
                    queue.add(last.right);
                }
            }
            result.add(temList);

        }

        return result;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}
