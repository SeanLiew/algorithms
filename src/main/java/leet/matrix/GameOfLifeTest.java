package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-20 18:42
 */
public class GameOfLifeTest {
    public void gameOfLife(int[][] board) {
        int[] neighbours = {1,0,-1};
        int rows = board.length;
        int columns = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int liveNeighbour = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //当前坐标
                        if (neighbours[i] == 0 && neighbours[j] == 0) {
                            continue;
                        }
                        int r = row + neighbours[i];
                        int col = column + neighbours[j];
                        //超出范围的情况
                        if (r < 0 || col < 0 || r > rows - 1 || col > columns - 1) {
                            continue;
                        }
                        if (Math.abs(board[r][col]) == 1) {
                            liveNeighbour++;
                        }
                    }
                }
                //当前是活细胞
                if (board[row][column] == 1) {
                    if (liveNeighbour < 2 || liveNeighbour > 3) {
                        //死了
                        board[row][column] = -1;
                    }
                }
                //当前是死细胞
                if (board[row][column] == 0 && liveNeighbour == 3) {
                    //复活
                    board[row][column] = 2;
                }
            }
        }
        //
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 2) {
                    board[row][column] = 1;
                }
                if (board[row][column] == -1) {
                    board[row][column] = 0;
                }
            }
        }
    }
    @Test
    public void test() {
        int[][] matrix = new int[4][3];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 0;
        matrix[1][0] = 0;
        matrix[1][1] = 0;
        matrix[1][2] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        matrix[3][0] = 0;
        matrix[3][1] = 0;
        matrix[3][2] = 0;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
        System.out.println("-----------");
        gameOfLife(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));

    }

}
