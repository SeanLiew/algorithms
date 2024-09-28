package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, 1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int index, int n, int k, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = index; i <= n; i++) {
                temp.add(i);
                backtrack(result, i + 1, n , k, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    @Test
    public void test() {

        System.out.println(JSON.toJSONString(combine(4, 4)));
    }

}
