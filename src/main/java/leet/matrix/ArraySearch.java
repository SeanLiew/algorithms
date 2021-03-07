package leet.matrix;

public class ArraySearch {


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++){
            for (int j = column - 1; j >=0; j--){
                int val = matrix[i][j];
                if (target == val){
                    return true;
                }
                if (target > val){
                    break;
                }
                if (target < val){
                    continue;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;

        System.out.println(findNumberIn2DArray(matrix, 3));

    }
}
