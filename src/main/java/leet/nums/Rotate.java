package leet.nums;

import leet.utils.GsonUtils;
import org.junit.Test;

/**
 * desc: 旋转数组
 * author: liuxiaozheng
 * time: 2020/8/7  10:25
 **/
public class Rotate {
    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6};
        System.out.println(GsonUtils.toJson(nums));
        rotate(nums, 1);
        System.out.println(GsonUtils.toJson(nums));
    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++){
            int dest = i + k;
            if (dest >= nums.length){
                dest -= nums.length;
            }
            int temp = nums[dest];
            nums[dest] = nums[i];
        }
    }
}
