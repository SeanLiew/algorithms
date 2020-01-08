package leet.array;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/7  17:06
 **/
public class MaxSubArray {
    @Test
    public void test(){
//        int[] arr = {1,-1,2,2,-8,5,5,6,7,-1,8};
        int[] arr = {-2,1,-3, 7};
        int i = maxSubArray(arr);

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

}
