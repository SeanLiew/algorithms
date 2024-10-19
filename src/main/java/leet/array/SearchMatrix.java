package leet.array;

import org.junit.Test;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }
        int columnLeft = 0;
        int columnRight = matrix[0].length - 1;
        if (matrix[row][columnRight] < target) {
            return false;
        }
        while (columnLeft <= columnRight) {
            int mid = (columnLeft + columnRight) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][columnLeft] == target) {
                return true;
            }
            if (matrix[row][columnRight] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                columnRight = mid - 1;
                continue;
            }
            if (matrix[row][mid] < target) {
                columnLeft = mid + 1;
            }
        }
        return false;
    }

    private int findRow (int[][] matrix, int target) {
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int row = -1;
        if (matrix[rowMax][0] < target) {
            return rowMax;
        }
        if (matrix[rowMin][0] > target) {
            return -1;
        }
        if (matrix.length == 1) {
            return 0;
        }
        while (rowMin <= rowMax) {
            int mid = (rowMin + rowMax) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            }
            if (matrix[rowMax][0] == target) {
                return rowMax;
            }
            if (matrix[mid][0] < target && matrix[mid + 1][0] > target) {
                return mid;
            }
            if (matrix[mid][0] > target) {
                rowMax = mid;
                continue;
            }
            if (matrix[mid][0] < target) {
                rowMin = mid;
            }

        }
        return row;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix, 5));
    }
}
