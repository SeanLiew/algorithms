package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.add(new Pair(i, j));
                    int area = 0;
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        area++;
                        int x = pair.x;
                        int y = pair.y;
                        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                            grid[x - 1][y] = 0;
                            queue.add(new Pair(x - 1, y));
                        }
                        if (x + 1 < row && grid[x + 1][y] == 1) {
                            grid[x + 1][y] = 0;
                            queue.add(new Pair(x + 1, y));
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                            grid[x][y - 1] = 0;
                            queue.add(new Pair(x, y - 1));
                        }
                        if (y + 1 < column && grid[x][y + 1] == 1) {
                            grid[x][y + 1] = 0;
                            queue.add(new Pair(x, y + 1));
                        }
                    }
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }


    @Test
    public void test() {
        int[][] matrix = new int[9][9];
        matrix[0][0] = 0;
        matrix[1][1] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 0;
        matrix[3][3] = 1;
        matrix[4][3] = 1;
        matrix[4][4] = 1;
        matrix[5][3] = 1;
        matrix[6][6] = 1;
        matrix[6][7] = 1;
        matrix[6][8] = 1;
        matrix[7][6] = 1;
        matrix[7][7] = 1;
        matrix[7][8] = 1;

        for (int i = 0 ; i < 9; i++) {
            System.out.println(JSON.toJSONString(matrix[i]));
        }
        System.out.println(maxAreaOfIsland(matrix));

    }
}
