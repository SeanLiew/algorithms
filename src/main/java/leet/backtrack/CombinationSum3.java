package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-29 20:08
 */
public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k ,n, 1);
        return result;
    }

    private void backtrack(int k, int n, int cur){
        if (k == 0) {
            return;
        }
        if (n < 0) {
            return;
        }
        if (n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i < 9; i++) {
            temp.add(cur);
            backtrack(k - 1, n - cur, cur + 1);
            temp.remove(temp.size() - 1);

        }
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum3(3, 7)));
    }
}
