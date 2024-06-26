package leet.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2021/3/3  18:38
 **/
public class OrderTraverse {
    TreeNode treeNode1 = new TreeNode(3);
    {
        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(2);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(4);
        TreeNode leftNode12 = new TreeNode(5);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(6);
        leftNode11.left = leftNode111;
    }
    @Test
    public void testPre(){
        List<Integer> integers = preOrderTraverse1(treeNode1);
        System.out.println(JSON.toJSONString(integers));
        integers = preOrderTraverse(treeNode1);
        System.out.println(JSON.toJSONString(integers));
        integers = preOrderTraverse(treeNode1, 6);
        System.out.println(JSON.toJSONString(integers));
    }

    @Test
    public void testMid(){
        List<Integer> integers = inOrderTraverse1(treeNode1);
        System.out.println(JSON.toJSONString(integers));
        integers = inOrderTraverse(treeNode1);
        System.out.println(JSON.toJSONString(integers));
        integers = inOrderTraverse2(treeNode1, 6);
        System.out.println(JSON.toJSONString(integers));

    }

    @Test
    public void testPost(){
        List<Integer> integers = postOrderTraverse1(treeNode1);
        System.out.println(JSON.toJSONString(integers));
        integers = postOrderTraverse(treeNode1);
        System.out.println(JSON.toJSONString(integers));
    }

    public List<Integer> preOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }
        }
        return result;
    }
    public List<Integer> preOrderTraverse(TreeNode root, int maxSize) {
        List<Integer> result = new ArrayList<>();

        TreeNode[] stack = new TreeNode[maxSize];
        int top = 0;
        stack[top] = root;
        while(top >= 0){
            TreeNode pop = stack[top--];
            result.add(pop.val);
            if (pop.right != null){
                stack[++top] = pop.right;
            }
            if (pop.left != null){
                stack[++top] = pop.left;
            }
        }
        return result;
    }

    public List<Integer> preOrderTraverse1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.left != null){
            List<Integer> leftVals = preOrderTraverse1(root.left);
            result.addAll(leftVals);
        }
        if (root.right != null){
            List<Integer> rightVals = preOrderTraverse1(root.right);
            result.addAll(rightVals);
        }
        return result;
    }

    public List<Integer> postOrderTraverse1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        if (root.left != null){
            List<Integer> leftVals = postOrderTraverse1(root.left);
            result.addAll(leftVals);
        }
        if (root.right != null){
            List<Integer> rightVals = postOrderTraverse1(root.right);
            result.addAll(rightVals);
        }
        result.add(root.val);
        return result;
    }

    public List<Integer> inOrderTraverse1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        if (root.left != null){
            List<Integer> leftVals = inOrderTraverse1(root.left);
            result.addAll(leftVals);
        }
        result.add(root.val);
        if (root.right != null){
            List<Integer> rightVals = inOrderTraverse1(root.right);
            result.addAll(rightVals);
        }
        return result;
    }

    public List<Integer> inOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;

        }
        return result;
    }
    public List<Integer> inOrderTraverse2(TreeNode root, int maxSize) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        TreeNode[] stack = new TreeNode[maxSize];
        int top = -1;
        TreeNode cur = root;
        while (top >= 0 || cur != null) {
            while (cur != null) {
                stack[++top] = cur;
                cur = cur.left;
            }
            cur = stack[top--];
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
    public List<Integer> postOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode r=stack.peek();//查看当前栈顶元素
            if(r.right==null){//如果当前栈顶元素没有右子节点
                result.add(stack.pop().val);//将其加入结果集
            }else{//否则,先保存当前结点的右子节点并把当前结点的右子节点置为null
                // (下次查看当前结点时就会知道右子节点已经遍历过，就可以将其加入结果集了),遍历当前结点右子树
                cur=r.right;
                r.right=null;
            }
        }
        return result;
    }
}
