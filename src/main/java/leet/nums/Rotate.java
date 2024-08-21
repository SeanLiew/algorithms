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
        //6,5,4,3,2,1
        System.out.println(GsonUtils.toJson(nums));
        rotate(nums, 2);
        System.out.println(GsonUtils.toJson(nums));
    }

    public void rotate(int[] nums, int k) {
        k = k  % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int min, int max) {
        while (min < max) {
            int temp = nums[min];
            nums[min] = nums[max];
            nums[max] = temp;
            min++;
            max--;
        }

    }

    @Test
    public void test2(){
        int[] nums = {1,2,3,4,5,6};
        //6,5,4,3,2,1
        System.out.println(GsonUtils.toJson(nums));
        rotate2(nums, 3);
        System.out.println(GsonUtils.toJson(nums));
    }

    public void rotate2(int[] nums, int k) {
        int step = nums.length / k;
        for (int i = 0; i < step; i++) {
            int left = i * k;
            int right = (i + 1) * k - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
    @Test
    public void test3(){
        int[] nums = {3,-100,3,99};
        //6,5,4,3,2,1
        System.out.println(GsonUtils.toJson(nums));
        rotate3(nums, 2);
        System.out.println(GsonUtils.toJson(nums));
    }

    public void rotate3(int[] nums, int k) {
        k = k  % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
