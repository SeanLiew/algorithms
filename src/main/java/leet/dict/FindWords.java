package leet.dict;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-26 19:21
 */
public class FindWords {
    class Pair {
        int row;
        int column;
        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    class Pairs {
        StringBuilder sb;
        int [] currentLocation;
        int index;
        Set<Pair> set;

        public Pairs(int [] currentLocation, StringBuilder sb, int index, Set<Pair> set) {
            this.currentLocation = currentLocation;
            this.sb = sb;
            this.index = index;
            this.set = set;
        }
    }
    public List<String> findWords2(char[][] board, String[] words) {
        int[][] dict = {{1, 0}, {-1, 0}, {0, -1}, {0, +1}};
        int row = board.length;
        int column = board[0].length;
        Map<Integer, Map<Integer, Pair>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Map<Integer, Pair> rowMap = map.get(i);
                if (rowMap == null) {
                    rowMap = new HashMap<>();
                    map.put(i, rowMap);
                }
                rowMap.put(j, new Pair(i, j));
            }
        }

        List<String> result = new ArrayList<>();
        out : for (String word : words) {
            char first = word.charAt(0);
            Queue<Pairs> queue = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (board[i][j] == first) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(first);
                        Set<Pair> set = new HashSet<>();
                        set.add(map.get(i).get(j));
                        int [] currentLocation = {i, j};
                        queue.offer(new Pairs(currentLocation, sb, 0, set));
                    }
                }
            }
            while (!queue.isEmpty()) {
                Pairs poll = queue.poll();
                int [] currentLocation = poll.currentLocation;
                int nextIndex = poll.index + 1;
                if (nextIndex > word.length() - 1) {
                    if (poll.sb.toString().equals(word)) {
                        result.add(word);
                        continue out;
                    }
                    continue;
                }
                char nextChar = word.charAt(nextIndex);
                for (int i = 0; i < 4; i++) {
                    //下个字符的行
                    int nextRow = currentLocation[0] + dict[i][0];
                    //下个字符的列
                    int nextColumn = currentLocation[1] + dict[i][1];
                    //校验行
                    if (nextRow < 0 || nextRow >= row) {
                        continue;
                    }
                    //校验列
                    if (nextColumn < 0 || nextColumn >= column) {
                        continue;
                    }
                    //判断是否使用过
                    Pair nextPair = map.get(nextRow).get(nextColumn);
                    if (poll.set.contains(nextPair)) {
                        continue;
                    }
                    //判断和字符串中下一个字符是否相同
                    if (nextChar != board[nextRow][nextColumn]) {
                        continue;
                    }
                    //重新放入
                    Set<Pair> set = new HashSet<>(poll.set);
                    set.add(nextPair);
                    int [] nextLocation = {nextRow, nextColumn};
                    StringBuilder nextSb = new StringBuilder(poll.sb);
                    nextSb.append(nextChar);
                    Pairs nextPairs = new Pairs(nextLocation, nextSb, nextIndex, set);
                    queue.offer(nextPairs);
                }
            }
        }
        return result;
    }

    class Trie{
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.children = new HashMap<>();

        }

        public void insert(String word){
            Trie trie = this;
            char[] chars = word.toCharArray();
            for (Character c : chars) {
                if (trie.children.get(c) == null) {
                    trie.children.put(c, new Trie());
                }
                trie = trie.children.get(c);
            }
            trie.word = word;
        }
    }

    int[][] dict = {{1, 0}, {-1, 0}, {0, -1}, {0, +1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie now = new Trie();
        for (String word : words) {
            now.insert(word);
        }

        Set<String> ans = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(now, board, i, j, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(Trie now, char[][] board, int row , int column, Set<String> ans) {
        if (now.children.get(board[row][column]) == null) {
            return;
        }
        char ch = board[row][column];

        now = now.children.get(ch);
        if (now.word != null) {
            ans.add(now.word);
        }

        board[row][column] = '#';

        for (int i = 0; i < 4; i++) {
            //下个字符的行
            int nextRow = row + dict[i][0];
            //下个字符的列
            int nextColumn = column + dict[i][1];
            //校验行
            if (nextRow < 0 || nextRow >= board.length) {
                continue;
            }
            //校验列
            if (nextColumn < 0 || nextColumn >= board[0].length) {
                continue;
            }
            dfs(now, board, nextRow, nextColumn, ans);
        }
        board[row][column] = ch;

    }


    @Test
    public void test() {
        char[][] board = new char[4][4];
        board[0][0] = 'o';
        board[0][1] = 'a';
        board[0][2] = 'a';
        board[0][3] = 'n';

        board[1][0] = 'e';
        board[1][1] = 't';
        board[1][2] = 'a';
        board[1][3] = 'e';

        board[2][0] = 'i';
        board[2][1] = 'h';
        board[2][2] = 'k';
        board[2][3] = 'r';

        board[3][0] = 'i';
        board[3][1] = 'f';
        board[3][2] = 'l';
        board[3][3] = 'v';

        String[] words = {"oath","pea","eat","rain"};

        System.out.println(findWords(board, words));

    }
    @Test
    public void test2() {
        char[][] board = new char[1][2];
        board[0][0] = 'a';
        board[0][1] = 'b';

        String[] words = {"ab"};

        System.out.println(findWords(board, words));

    }
    @Test
    public void test3() {
        char[][] board = new char[3][3];
        board[0][0] = 'a';
        board[0][1] = 'b';
        board[0][2] = 'c';

        board[1][0] = 'a';
        board[1][1] = 'e';
        board[1][2] = 'd';

        board[2][0] = 'a';
        board[2][1] = 'f';
        board[2][2] = 'g';
        System.out.println(JSON.toJSONString(board));

        //abc
        //aed
        //afg
        String[] words = {"eaabcdgfa"};

        System.out.println(findWords(board, words));

    }
}
