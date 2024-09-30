package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-29 18:55
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, 0, target, result, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates, int currentIndex, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target < 0) {
            return;
        } else if (target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = currentIndex; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test3() {
        int[] candidates = {2,3,6,7};
        int target = 7;

        System.out.println(JSON.toJSONString(combinationSum(candidates, target)));
    }
}
