package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class RotateTest {
    public void rotate(int[][] matrix) {
        boolean odd = matrix.length % 2 == 1;
        int layer = odd ? (matrix.length + 1) / 2 : matrix.length / 2;

        //层次循环
        for (int i = 0; i < layer; i++ ) {
            //奇数最后一层，只有一个数字
            if (odd && i == layer - 1) {
                return;
            }

            //left - right循环
            int width = matrix.length - 1;
            int maxLengthOfThisLayer = width - i;

            for (int j = i; j <  maxLengthOfThisLayer; j++ ) {
                //指针循环
                int firstRow = i;
                int firstColumn = j;
                //暂存第四个
                int temp = matrix[width - firstColumn][firstRow];
                //新第四个
                matrix[width - firstColumn][firstRow] = matrix[maxLengthOfThisLayer][width - firstColumn];
                //新第三个
                matrix[maxLengthOfThisLayer][width - firstColumn] = matrix[firstColumn][maxLengthOfThisLayer];
                //新第二个
                matrix[firstColumn][maxLengthOfThisLayer] = matrix[firstRow][firstColumn];
                //新第一个
                matrix[firstRow][firstColumn] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println("--------------");

        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
    }




    @Test
    public void test2() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println("--------------");
        rotate2(matrix);

    }
    @Test
    public void test3() {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 12;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 17;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 31;
        matrix[3][0] = 39;
        matrix[3][1] = 30;
        matrix[3][2] = 32;
        matrix[3][3] = 33;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
        System.out.println("--------------");
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
    }
    @Test
    public void test4() {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 12;
        matrix[0][4] = 13;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 17;
        matrix[1][4] = 18;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 21;
        matrix[2][4] = 22;
        matrix[3][0] = 19;
        matrix[3][1] = 12;
        matrix[3][2] = 13;
        matrix[3][3] = 23;
        matrix[3][4] = 23;
        matrix[4][0] = 49;
        matrix[4][1] = 42;
        matrix[4][2] = 43;
        matrix[4][3] = 43;
        matrix[4][4] = 43;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
        System.out.println(JSON.toJSONString(matrix[4]));
        System.out.println("--------------");

        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
        System.out.println(JSON.toJSONString(matrix[4]));
    }
    @Test
    public void test5() {
        int[][] matrix = new int[6][6];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 12;
        matrix[0][4] = 13;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 17;
        matrix[1][4] = 18;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 21;
        matrix[2][4] = 22;
        matrix[3][0] = 19;
        matrix[3][1] = 12;
        matrix[3][2] = 13;
        matrix[3][3] = 23;
        matrix[3][4] = 23;
        matrix[4][0] = 49;
        matrix[4][1] = 42;
        matrix[4][2] = 43;
        matrix[4][3] = 43;
        matrix[4][4] = 43;

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
        System.out.println(JSON.toJSONString(matrix[4]));
        System.out.println(JSON.toJSONString(matrix[5]));
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(matrix[3]));
        System.out.println(JSON.toJSONString(matrix[4]));
        System.out.println(JSON.toJSONString(matrix[5]));
    }
}
