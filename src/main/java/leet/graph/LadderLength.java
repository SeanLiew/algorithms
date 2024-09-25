package leet.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-25 20:44
 */
public class LadderLength {
    class Pair {
        String str;
        int d;

        public Pair(String str, int d){
            this.str = str;
            this.d = d;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String str : wordList) {
            words.add(str);
        }
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.str.equals(endWord)) {
                return poll.d;
            }
            for (String str : wordList) {
                if (visited.contains(str)) {
                    continue;
                }
                if (oneDiff(poll.str, str)) {
                    queue.offer(new Pair(str, poll.d + 1));
                    visited.add(str);
                }
            }
        }
        return 0;
    }

    private boolean oneDiff(String a, String b) {
        if (a.equals(b)) {
            return false;
        }
        int num = 0;
        for (int i = 0; i< a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
            }
            if (num > 1) {
                return false;
            }
        }
        return num == 1;
    }


    @Test
    public void test() {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength("hit", "cog", list));

    }
}
