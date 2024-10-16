package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-16 15:14
 */
public class SolveNQueens {
    String[][] board = null;
    int n = 0;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int _n) {
        n = _n;

        board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        dfs(0, new ArrayList<>());
        return result;

    }

    private void dfs(int row, List<String> tempList) {
        if (row == n) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int column = 0; column < n; column++) {
            if (!valid(row, column)) {
                continue;
            }
            board[row][column] = "Q";
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(column, column + 1, "Q");
            tempList.add(stringBuilder.toString());

            dfs(row + 1, tempList);

            board[row][column] = ".";
            stringBuilder.replace(column, column + 1, ".");
            tempList.remove(tempList.size() - 1);
        }
    }

    private boolean valid (int row, int column) {
        for (int i = 0; i < row; i++) {
            if(board[i][column].equals("Q")) {
                return false;
            }
        }

        //左上角
        for (int i = row - 1, j = column - 1; i >= 0 && j >=0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        //右上角
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test4() {
        System.out.println(JSON.toJSONString(solveNQueens(5)));
    }
    @Test
    public void test5() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".");
        stringBuilder.append(".");
        stringBuilder.append(".");
        stringBuilder.replace(1, 2, "Q");
        System.out.println(stringBuilder.toString());
    }

}
