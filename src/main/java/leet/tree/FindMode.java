package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-23 00:42
 */
public class FindMode {
    public int[] findMode(TreeNode root) {
        List<Integer> list = postorder(root);
        //
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            Integer count = map.get(i);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            max = Math.max(count, max);
            map.put(i, count);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] ints = new int[result.size()];
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            ints[index++] = result.get(i);
        }
        return ints;

    }
    public List<Integer> postorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> left = postorder(root.left);
        if (left != null) {
            list.addAll(left);
        }
        List<Integer> right = postorder(root.right);
        if (right != null) {
            list.addAll(right);
        }
        list.add(root.val);
        return list;
    }


    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode rightNode1 = new TreeNode(2);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(4);
        TreeNode leftNode12 = new TreeNode(5);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;


        int[] mode = findMode(treeNode1);
        System.out.println(JSON.toJSONString(mode));

    }
}
