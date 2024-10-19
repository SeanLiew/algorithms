package leet.dp;

import org.junit.Test;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            int max = Integer.max(curNum, curNum + dp[i - 1]);
            dp[i] = max;
            res = Integer.max(res, max);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {2,-5,3};
        System.out.println(maxSubArray(nums));
    }
}
