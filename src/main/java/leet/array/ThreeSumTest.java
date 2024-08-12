package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-07 21:19
 */
public class ThreeSumTest {
    @Test
    public void test(){
//        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr = {0,0,0,0};
        List<List<Integer>> lists = threeSum(arr);

        System.out.println(JSON.toJSONString(lists));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pointer = i;
            int left = pointer + 1;
            int right = nums.length - 1;
            while (left < right) {
                int result = nums[pointer] + nums[left] + nums[right];
                if (result == 0){
                    lists.add(Arrays.asList(nums[pointer], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                }
                if (result > 0){
                    while (left < right && nums[right] == nums[--right]);
                }
                if (result < 0){
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return lists;
    }
}
