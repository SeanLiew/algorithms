package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroColumn = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            int[] matrix1 = matrix[row];
            for (int column = 0; column < matrix1.length; column++) {
                if (matrix[row][column] == 0) {
                    zeroColumn.add(column);
                    zeroRow.add(row);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int[] matrix1 = matrix[row];
            for (int column = 0; column < matrix1.length; column++) {
                if (zeroRow.contains(row) || zeroColumn.contains(column)) {
                    matrix[row][column] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    @Test
    public void test2() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 5;
        matrix[1][1] = 0;
        matrix[1][2] = 7;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println("-----------");
        setZeroes(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));

    }
}
