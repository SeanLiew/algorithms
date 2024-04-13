package leet.matrix;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

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
        System.out.println(JSON.toJSONString(spiralOrder(matrix)));
        System.out.println(JSON.toJSONString(spiralOrder3(matrix)));

    }
}
