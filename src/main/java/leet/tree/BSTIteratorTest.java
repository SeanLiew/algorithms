package leet.tree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-11 21:27
 */
public class BSTIteratorTest {
    class BSTIterator {

        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }


        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode rightNode1 = new TreeNode(5);
        treeNode1.left = leftNode1;
        treeNode1.right = rightNode1;

        TreeNode leftNode11 = new TreeNode(3);
        TreeNode leftNode12 = new TreeNode(4);
        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        TreeNode leftNode111 = new TreeNode(6);
        rightNode1.left = leftNode111;

        BSTIterator bSTIterator = new BSTIterator(treeNode1);
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
    }
}
