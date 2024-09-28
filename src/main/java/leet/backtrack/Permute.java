package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {
    public List<List<Integer>> permute3(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,  nums, 0, nums.length - 1, new ArrayList<>());
        return result;
    }
    private void backtrack(List<List<Integer>> result, int[] nums, int start, int end, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= end; i++) {
                int tempIndex = i;
                if (i >= nums.length) {
                    tempIndex = tempIndex % nums.length;
                }
                temp.add(nums[tempIndex]);
                backtrack(result,  nums, i + 1, i + nums.length - temp.size(), temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {

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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    @Test
    public void test() {
        int[] arr = {1,2,3};

        System.out.println(JSON.toJSONString(permute(arr)));
    }
}
