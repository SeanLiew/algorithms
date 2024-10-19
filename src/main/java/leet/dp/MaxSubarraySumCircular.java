package leet.dp;

import org.junit.Test;

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular1(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp[0] = nums[0];
        dp_min[0] = nums[0];
        int max = dp[0];
        int min = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(nums[i], nums[i] + dp[i - 1]);
            max = Integer.max(max, dp[i]);
            sum += nums[i];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            dp_min[i] = Integer.min(nums[i], nums[i] + dp_min[i - 1]);
            min = Integer.min(min, dp_min[i]);
        }
        return Integer.max(max, sum - min);

    }
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp[0] = nums[0];
        dp_min[0] = nums[0];
        int max = dp[0];
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(nums[i], nums[i] + dp[i - 1]);
            max = Integer.max(max, dp[i]);
            sum += nums[i];

            dp_min[i] = Integer.min(nums[i], nums[i] + dp_min[i - 1]);
            min = Integer.min(min, dp_min[i]);
        }
        //整个数组都是负数
        if (sum == min) {
            return max;
        }
        return Integer.max(max, sum - min);

    }

    @Test
    public void test(){
//        int[] nums = {-2};
//        int[] nums = {9,-4,-7,9};
        int[] nums = {-3,-2,-3};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
