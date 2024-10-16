package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-16 14:27
 */
public class TotalNQueens {

    char[][] board = null;
    int n = 0;
    int result = 0;


    public int totalNQueens(int _n) {
        n = _n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0);
        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int column = 0; column < n; column++) {
            if (!valid(row, column)) {
                continue;
            }
            board[row][column] = 'Q';
            dfs(row + 1);
            board[row][column] = '.';
        }
    }
    //0 1 2 3 4
    //1 1 1 1 1
    //1 1 1 1 1
    //1 1 1 1 1
    private boolean valid (int row, int column) {
        for (int i = 0; i < row; i++) {
            if(board[i][column] == 'Q') {
                return false;
            }
        }

        //左上角
        for (int i = row - 1, j = column - 1; i >= 0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //右上角
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }




    @Test
    public void test3() {
        System.out.println(JSON.toJSONString(totalNQueens(5)));
    }


}
