package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,  nums, new HashSet<>(), new ArrayList<>());
        return result;
    }
    private void backtrack(List<List<Integer>> result, int[] nums, Set<Integer> set, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (Integer num : nums) {
                if (set.contains(num)) {
                    continue;
                }
                temp.add(num);
                set.add(num);
                backtrack(result,  nums, set, temp);
                temp.remove(temp.size() - 1);
                set.remove(num);
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {1,2,3};

        System.out.println(JSON.toJSONString(permute(arr)));
    }
}
