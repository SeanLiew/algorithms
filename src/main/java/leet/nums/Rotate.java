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
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
