package leet.divide;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-17 19:36
 */
public class ConstructFourTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        if (rowStart == rowEnd && columnStart == columnEnd) {
            return new Node(grid[rowStart][columnStart] == 1,true);
        }
        int rowMid = (rowStart + rowEnd) / 2;
        int columnMid = (columnStart + columnEnd) / 2;
        Node topLeft = construct(grid, rowStart, rowMid, columnStart, columnMid);
        Node topRight = construct(grid, rowStart, rowMid, columnMid + 1, columnEnd);
        Node bottomLeft = construct(grid, rowMid + 1, rowEnd, columnStart, columnMid);
        Node bottomRight = construct(grid, rowMid + 1, rowEnd, columnMid + 1, columnEnd);

        //合并
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val)
            || (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val)) {
                return new Node(topLeft.val,true);
            }
        }
        boolean val = topLeft.isLeaf || topRight.isLeaf || bottomLeft.isLeaf || bottomRight.isLeaf;
        return new Node(val,false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        int length = grid.length;
        return construct(grid, 0, length - 1, 0, length -1);
    }



    @Test
    public void test() {
        //0,0,0,0
        //0,0,0,0
        //1,1,1,1
        //1,1,1,1
        int[][] matrix = {{0,0,0,0}, {0,0,0,0}, {1,1,1,1}, {1,1,1,1}};

        Node construct = construct(matrix);
        System.out.println(1);

    }

}
