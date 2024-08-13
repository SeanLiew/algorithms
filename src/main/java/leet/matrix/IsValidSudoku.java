package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-13 21:09
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set[] rowSet = new Set[9];
        Set[] columnSet = new Set[9];
        Set[] mSet = new Set[9];



        return false;
    }

    @Test
    public void test() {
        char[][] matrix = new char[9][9];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;

        System.out.println(JSON.toJSONString(matrix));
        System.out.println(isValidSudoku(matrix));

    }
}
