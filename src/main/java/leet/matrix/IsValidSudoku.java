package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-13 21:09
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowNum = new int[9][9];
        int[][] columnNum = new int[9][9];
        int[][][] subNum = new int[3][3][9];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char c = board[row][column];
                if (c == '.') {
                    continue;
                }
                int index = c - '0' - 1;
                rowNum[row][index]++;
                columnNum[column][index]++;
                subNum[row/3][column/3][index]++;
                if (rowNum[row][index] > 1 || columnNum[column][index] > 1 || subNum[row/3][column/3][index] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] matrix = new char[9][9];
        matrix[0][0] = 1;
        matrix[0][1] = '.';
        matrix[0][2] = 3;
        matrix[0][3] = 4;

        System.out.println(JSON.toJSONString(matrix));
        System.out.println(isValidSudoku(matrix));

    }
}
