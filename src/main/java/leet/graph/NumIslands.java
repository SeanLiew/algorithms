package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, row, column);
                }

            }
        }
        return result;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    queue.add(new Pair(i, j));
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        int x = pair.x;
                        int y = pair.y;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add(new Pair(x - 1, y));
                        }
                        if (x + 1 < row && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add(new Pair(x + 1, y));
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(new Pair(x, y - 1));
                        }
                        if (y + 1 < column && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(new Pair(x, y + 1));
                        }
                    }
                }
            }
        }
        return result;
    }
    public void dfs (char[][] grid, int x, int y, int row, int column) {
        if (x < 0 || x >= row || y < 0 || y >= column) {
            return;
        }
        if (grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y, row, column);
        dfs(grid, x + 1, y, row, column);
        dfs(grid, x, y - 1, row, column);
        dfs(grid, x, y + 1, row, column);
    }


    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        //总1的数量
        int waters = 0;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //陆地,union上下左右4个点
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union((i - 1) * column + j, i * column + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        unionFind.union((i + 1) * column + j, i * column + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * column + (j - 1), i * column + j);

                    }
                    if (j + 1 < column && grid[i][j + 1] == '1') {
                        unionFind.union(i * column + (j + 1), i * column + j);
                    }
                } else {
                    waters++;
                }
            }
        }

        return unionFind.count - waters;
    }

    @Test
    public void test() {
        char[][] matrix = new char[3][3];
        matrix[0][0] = '1';
        matrix[0][1] = '1';
        matrix[0][2] = '1';
        matrix[1][0] = '0';
        matrix[1][1] = '1';
        matrix[1][2] = '0';
        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '1';

        System.out.println(JSON.toJSON(matrix[0]));
        System.out.println(JSON.toJSON(matrix[1]));
        System.out.println(JSON.toJSON(matrix[2]));
        System.out.println(numIslands3(matrix));
        System.out.println(JSON.toJSON(matrix[0]));
        System.out.println(JSON.toJSON(matrix[1]));
        System.out.println(JSON.toJSON(matrix[2]));

    }

}
