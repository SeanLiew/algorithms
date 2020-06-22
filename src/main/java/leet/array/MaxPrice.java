package leet.array;

import org.junit.Test;

/**
 * desc: 最大差值
 * author: liuxiaozheng
 * time: 2020/6/22  16:08
 **/
public class MaxPrice {
    @Test
    public void test(){
        int[] arr = {1,-1,2,2,-8,5,5,6,7,-1,8};
//        int[] arr = {-2,1,-3, 7};
        int i = maxPrice(arr);

        System.out.println(i);
    }

    public int maxPrice(int[] nums) {
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1 ; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] - nums[i] >maxGap){
                    maxGap = nums[j] - nums[i];
                }
            }
        }
        return maxGap;
    }
}
