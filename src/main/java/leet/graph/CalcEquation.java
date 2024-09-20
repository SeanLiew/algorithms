package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CalcEquation {

    class Cell {
        String str;
        double div;

        public Cell(String str, double div) {
            this.str = str;
            this.div = div;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Cell>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> str = equations.get(i);
            String s1 = str.get(0);
            String s2 = str.get(1);
            map.computeIfAbsent(s1, k -> new ArrayList<>()).add(new Cell(s2, values[i]));
            map.computeIfAbsent(s2, k -> new ArrayList<>()).add(new Cell(s1, 1/values[i]));
        }
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, map, res, i, new HashSet<>());
        }
        return res;
    }
    public void dfs (String src, String dst, double cur, Map<String, List<Cell>> map, double[] res, int index, Set<String> visited) {
        if (!visited.add(src)) {
            return;
        }
        if (src.equals(dst) && map.containsKey(src)) {
            res[index] = cur;
            return;
        }

        for (Cell item : map.getOrDefault(src, new ArrayList<>())) {
            dfs(item.str, dst, cur * item.div, map, res, index, visited);
        }
    }


    @Test
    public void test() {
        List<List<String>> equations = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        equations.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("B");
        list2.add("C");
        equations.add(list2);
        double[] values = {2.0, 1};
        List<List<String>> queries = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("C");
        queries.add(list3);
        List<String> list4 = new ArrayList<>();
        list4.add("A");
        list4.add("E");
        queries.add(list4);
        double[] doubles = calcEquation(equations, values, queries);
        System.out.println(JSON.toJSONString(doubles));
    }
}
