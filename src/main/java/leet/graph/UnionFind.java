package leet.graph;

public class UnionFind {

    //一维数组
    int [] root;

    //记录数量
    int count = 0;

    UnionFind (char[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        root = new int[row * column];
        count = row * column;
        //初始化
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    public int find (int x) {
        if (x == root[x]) {
            return x;
        } else {
            root[x] = find(root[x]);
            return root[x];
        }
    }

    //合并
    public void union (int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
            count--;
        }
    }
}
