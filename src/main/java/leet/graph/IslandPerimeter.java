package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int row = grid.length;
        int column = grid[0].length;
        int result  = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = dx[k] + i;
                        int y = dy[k] + j;
                        if (x < 0 || x >= row || y < 0 || y >= column || grid[x][y] == 0) {
                            cnt++;
                        }
                    }
                    result += cnt;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 0;
        matrix[1][1] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 0;
        matrix[3][3] = 0;

        System.out.println(JSON.toJSON(matrix[0]));
        System.out.println(JSON.toJSON(matrix[1]));
        System.out.println(JSON.toJSON(matrix[2]));
        System.out.println(JSON.toJSON(matrix[3]));
        System.out.println(islandPerimeter(matrix));
        System.out.println(JSON.toJSON(matrix[0]));
        System.out.println(JSON.toJSON(matrix[1]));
        System.out.println(JSON.toJSON(matrix[2]));
        System.out.println(JSON.toJSON(matrix[3]));

    }
}
