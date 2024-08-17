package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/9 10:09
 */
public class RotatePrint {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int[] result = new int[matrix.length * matrix[0].length];
        int k = 0;

        while(top <= bottom && left <= right){
            //left -> right
            for (int i=left; i <=right; i++){
                result[k++] = matrix[top][i];
            }
            top++;

            //top -> bottom
            for (int i=top; i <=bottom; i++){
                result[k++] = matrix[i][right];
            }
            right--;

            //right -> left
            for (int i=right; i >=left && top <= bottom; i--){
                result[k++] = matrix[bottom][i];
            }
            bottom--;

            //bottom -> top
            for (int i=bottom; i >=top && left <= right; i--){
                result[k++] = matrix[i][left];
            }
            left++;
        }

        return result;
    }
    public int[] spiralOrder2(int[][] matrix) {
        //特判
        if(matrix == null ||matrix.length == 0){
            return new int[0];
        }

        //初始化
        int left = 0, top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length - 1;
        int[] res = new int[(right+1)*(bottom+1)];
        int k = 0;

        //循环打印
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){ //从左到右
                res[k++] = matrix[top][i];
            }
            top ++;
            for(int i = top; i <= bottom; i++){ //从上到下
                res[k++] = matrix[i][right];
            }
            right --;
            for(int i = right; i >= left && top <= bottom; i--){    //从右到左
                res[k++] = matrix[bottom][i];
            }
            bottom --;
            for(int i = bottom; i >= top && left <= right; i--){    //从下到上
                res[k++] = matrix[i][left];
            }
            left ++;
        }
        return res;

    }

    public int[] spiralOrder3(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int index = 0;
        while (top <= bottom && left <= right) {
            //left-right
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            //top-bottom
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            //right-left
            for (int i = right; i >= left && top <= bottom; i--) {
                result[index++] = matrix[bottom][i];
            }
            bottom--;
            //bottom-top
            for (int i = bottom; i >= top && left <= right; i--) {
                result[index++] = matrix[i][left];
            }
            left++;
        }
        return result;
    }
    public List<Integer> spiralOrder4(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result =  new ArrayList<>();

        while (top <= bottom && left <= right) {
            //left - right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            //top - bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            //right - left
            for (int i = right; i >= left && top <= bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            //bottom - top
            for (int i = bottom; i >= top && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

    @Test
    public void test() {
        int[][] matrix = new int[3][4];
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

        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));
        System.out.println(JSON.toJSONString(spiralOrder4(matrix)));

    }

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
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix[0]));
        System.out.println(JSON.toJSONString(matrix[1]));
        System.out.println(JSON.toJSONString(matrix[2]));

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
