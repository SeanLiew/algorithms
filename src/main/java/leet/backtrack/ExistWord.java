package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-16 16:27
 */
public class ExistWord {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int [][] code = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    Map<Integer, Map<Integer, Pair>> dictMap = new HashMap<>();

    boolean exist = false;

    char[][] board;

    public boolean exist(char[][] _board, String word) {
        board = _board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Map<Integer, Pair> rowMap = dictMap.get(i);
                if (rowMap == null) {
                    rowMap = new HashMap<>();
                    dictMap.put(i, rowMap);
                }
                rowMap.put(j, new Pair(i, j));
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!exist && board[i][j] == word.charAt(0)) {
                    Set<Pair> set = new HashSet<>();
                    set.add(dictMap.get(i).get(j));
                    backtrack(i, j, word, 0, set);
                }
            }
        }
        return exist;
    }

    private void backtrack(int row, int column, String word, int currentIndex, Set<Pair> set) {
        if (exist) {
            return;
        }
        if (board[row][column] != word.charAt(currentIndex)) {
            return;
        }
        if (currentIndex == word.length() - 1) {
            exist = true;
            return;
        }
        for (int i = 0; i < code.length; i++) {
            int nextRow = row + code[i][0];
            int nextColumn = column + code[i][1];
            Map<Integer, Pair> rowMap = dictMap.get(nextRow);
            if (rowMap == null) {
                continue;
            }
            Pair nextPair = rowMap.get(nextColumn);
            if (nextPair == null) {
                continue;
            }
            if (set.contains(nextPair)) {
                continue;
            }
            if (board[nextRow][nextColumn] != word.charAt(currentIndex + 1)) {
                continue;
            }
            set.add(dictMap.get(nextRow).get(nextColumn));
            backtrack(nextRow, nextColumn, word, currentIndex + 1, set);
            set.remove(dictMap.get(nextRow).get(nextColumn));
        }
    }

    @Test
    public void test() {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};

        String word = "ABE";
        System.out.println(exist(board, word));
    }
}
