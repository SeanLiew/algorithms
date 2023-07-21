package leet.array;

import org.junit.Test;

/**
 * desc: 最大连续子数组
 * author: liuxiaozheng
 * time: 2020/1/7  17:06
 **/
public class MaxSubArray {
    @Test
    public void test(){
        int[] arr = {1,-1,2,2,-8,5,5,6,7,-1,8};
//        int[] arr = {-2,1,-3, 7};
        int i = maxSubArray2(arr);

        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum > max){
                    max = sum;
                }
            }
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

}
