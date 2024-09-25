package leet.graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-25 19:22
 */
public class MinMutation {
    class Pair {
        String str;
        int d;

        public Pair(String str, int d){
            this.str = str;
            this.d = d;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] chars = {'A', 'C', 'G', 'T'};
        Map<String, Integer> map = new HashMap<>();
        for (String str : bank) {
            map.put(str, 0);
        }
        if (startGene.equals(endGene)) {
            return 0;
        }
        if (!map.containsKey(endGene)) {
            return -1;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene, 0));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.str.equals(endGene)) {
                return poll.d;
            }
            String str = poll.str;
            for (int i = 0; i < str.length(); i++) {
                char sc = str.charAt(i);
                for (char c : chars) {
                    if (sc == c) {
                        continue;
                    }
                    StringBuffer sb = new StringBuffer(str);
                    sb.setCharAt(i, c);
                    String newStr = sb.toString();
                    if (!map.containsKey(newStr) || map.get(newStr) == 1) {
                        continue;
                    }
                    map.put(newStr, 1);
                    queue.offer(new Pair(newStr, poll.d + 1));
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        System.out.println(minMutation("AACCGGTT", "AAACGGTA", bank));

    }
}
