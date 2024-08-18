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
        //行数
        int m = matrix.length;
        //列数
        int n = matrix[0].length;
        boolean firstRow0 = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow0 = true;
            }
        }
        boolean firstColumn0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumn0 = true;
            }
        }
        //遍历矩阵，用第一行第一列记录0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //遍历矩阵，根据第一行第一列记录是否为0，设置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //判断第一行本身是否有0，有的话，把这一行设置为0
        if (firstRow0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        //判断第一列本身是否有0，有的话，把这一列设置为0
        if (firstColumn0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void test2() {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 13;
        matrix[1][0] = 5;
        matrix[1][1] = 0;
        matrix[1][2] = 7;
        matrix[1][3] = 7;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println("-----------");
        setZeroes2(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));

    }
}
