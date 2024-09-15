package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CircleArea {
    int row, column;
    Queue<Pair> queue;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        //第一行和最后一行
        for (int m = 0; m < column; m++) {
            dfs(board, 0, m, row, column);
            dfs(board, row - 1, m, row, column);
        }
        //第一列和最后一列
        for (int m = 0; m < row; m++) {
            dfs(board, m, 0, row, column);
            dfs(board, m, column - 1, row, column);
        }
        //换回来
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j,int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column) {
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == 'A') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i - 1, j, row, column);
        dfs(board, i + 1, j, row, column);
        dfs(board, i, j - 1, row, column);
        dfs(board, i, j + 1, row, column);
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        row = board.length;
        column = board[0].length;

        queue = new LinkedList<>();
        //第一行和最后一行
        for (int m = 0; m < column; m++) {
            if (board[0][m] == 'O') {
                queue.offer(new Pair(0, m));
            }
            if (board[row - 1][m] == 'O') {
                queue.offer(new Pair(row - 1, m));
            }
        }
        //第一列和最后一列
        for (int m = 0; m < row; m++) {
            if (board[m][0] == 'O') {
                queue.offer(new Pair(m, 0));
            }
            if (board[m][column - 1] == 'O') {
                queue.offer(new Pair(m, column - 1));
            }
        }

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;
            board[x][y] = 'A';
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                queue.add(new Pair(x - 1, y));
            }
            if (x + 1 < row && board[x + 1][y] == 'O') {
                queue.add(new Pair(x + 1, y));
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                queue.add(new Pair(x, y - 1));
            }
            if (y + 1 < column && board[x][y + 1] == 'O') {
                queue.add(new Pair(x, y + 1));
            }
        }
        //换回来
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    @Test
    public void test() {
        char[][] matrix = new char[4][4];
        matrix[0][0] = 'X';
        matrix[0][1] = 'X';
        matrix[0][2] = 'X';
        matrix[0][3] = 'X';
        matrix[1][0] = 'X';
        matrix[1][1] = 'O';
        matrix[1][2] = 'O';
        matrix[1][3] = 'X';
        matrix[2][0] = 'X';
        matrix[2][1] = 'X';
        matrix[2][2] = 'X';
        matrix[2][3] = 'X';
        matrix[3][0] = 'X';
        matrix[3][1] = 'O';
        matrix[3][2] = 'X';
        matrix[3][3] = 'X';

        System.out.println(JSON.toJSON(matrix[0]));
        System.out.println(JSON.toJSON(matrix[1]));
        System.out.println(JSON.toJSON(matrix[2]));
        System.out.println(JSON.toJSON(matrix[3]));
        System.out.println("-------------------");
        solve2(matrix);
        System.out.println(JSON.toJSON(matrix[0]));
        System.out.println(JSON.toJSON(matrix[1]));
        System.out.println(JSON.toJSON(matrix[2]));
        System.out.println(JSON.toJSON(matrix[3]));

    }
}
