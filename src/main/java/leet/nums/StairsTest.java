package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/10  11:25
 **/
public class StairsTest {
    @Test
    public void test(){
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }

    @Test
    public void testNumberOfSteps(){
        System.out.println(numberOfSteps(14));

    }

    public int numberOfSteps(int num) {
        int[] nums = new int[1000001];

        nums[0] = 0;
        for (int i = 1; i < nums.length; i++){
            if (i % 2 == 1){
                nums[i] = nums[i-1] + 1;
            } else {
                nums[i] = nums[i/2] + 1;
            }
        }
        return nums[num];
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];

    }

    public int climbStairs2(int n) {
        if (n ==0 || n == 1){
            return 1;
        }
        int a =0, b=1, sum=0;

        for (int i=0; i<n; i++){
            sum = (a + b) % 1000000007;

            a = b;

            b = sum;
        }


        return sum;

    }

    @Test
    public void test2(){
        final int SHARED_SHIFT   = 16;
        final int SHARED_UNIT    = (1 << SHARED_SHIFT);
        final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
        final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

        System.out.println(SHARED_UNIT);
        System.out.println(MAX_COUNT);
        System.out.println(EXCLUSIVE_MASK);
    }

    @Test
    public void testMinCostClimbingStairs(){
        int[] cost = new int[]{5, 2, 1, 4};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] f = new int[1024];
        f[0] = f[1] = 0;
        for (int i = 2; i <= cost.length; i++){
            int num1 = f[i - 2] + cost[i - 2];
            int num2 = f[i - 1] + cost[i - 1];
            f[i] =  num1 < num2 ? num1 : num2;
        }
        return f[cost.length];
    }

    @Test
    public void testRob(){
        int[] cost = new int[]{5, 2, 1, 4};
        System.out.println(rob(cost));
        System.out.println(rob(new int[]{10, 15, 20}));
        System.out.println(rob(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
    public int rob(int[] nums) {
        int[] dp = new int[101];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (i == 1){
                dp[i] =  nums[0] > nums[1] ? nums[0] : nums[1];
            }else {
                int num1 = dp[i-2] + nums[i];
                int num2 = dp[i-1];
                dp[i] =  num1 > num2 ? num1 : num2;
            }
        }
        return dp[nums.length-1];
    }
    @Test
    public void testRob2(){
        System.out.println(rob2(new int[]{10, 15, 20}));
        System.out.println(rob2(new int[]{10}));
        System.out.println(rob2(new int[]{8,7}));
    }
    public int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        System.arraycopy(nums,0, nums1, 0, nums.length-1);
        System.arraycopy(nums,1, nums2, 0, nums.length-1);
        int rob1 = rob(nums1);
        int rob2 = rob(nums2);
        return rob1 > rob2 ? rob1 : rob2;
    }

    @Test
    public void testNumDecodings(){
        System.out.println(numDecodings2("101"));
    }
    public int numDecodings(String s) {
        int[] dp = new int[101];
        dp[0] = 1;
        for (int i=0; i<s.length();i++){
            int cur = s.charAt(i) - '0';
            if (i==0){
                if (cur == 0){
                    return 0;
                } else {
                    continue;
                }
            }
            if (cur == 0){
                if (i==0){
                    return 0;
                }
                int pre = s.charAt(i - 1) - '0';
                if (pre + cur == 0){
                    return 0;
                }
                if (pre * 10 + cur > 26) {
                    return 0;
                }
                if (i == 1){
                    dp[i] = dp[0];
                    continue;
                }
                dp[i] = dp[i-2];
                continue;
            }
            dp[i] = dp[i-1];
            int pre = s.charAt(i - 1) - '0';
            if (pre == 0){
                dp[i] = dp[i-1];
                continue;
            }
            if ((pre *10) + cur <= 26) {
                if (i == 1){
                    dp[i] = dp[i] + 1;
                } else {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[s.length()-1];
    }
    public int numDecodings2(String s) {
        int[] dp = new int[101];
        dp[0] = 1;
        for (int i=0; i<s.length();i++){
            if (i == 0){
                dp[i] = s.charAt(i) == '0' ? 0 : 1;
            } else {
                if (s.charAt(i) != '0'){
                    dp[i] = dp[i] + dp[i-1];
                }
                int cur = s.charAt(i) - '0';
                int pre = s.charAt(i - 1) - '0';
                if (pre == 1 || pre == 2){
                    if ((pre * 10) + cur <= 26){
                        if (i == 1){
                            dp[i] = dp[i] + 1;
                        } else {
                            dp[i] = dp[i] + dp[i - 2];
                        }
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    @Test
    public void testGetMaximumGenerated(){
        System.out.println(getMaximumGenerated(4));
    }
    public int getMaximumGenerated(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i <= n; i++){
            if (2 <= 2 * i && 2 * i <= n){
                dp[i * 2] = dp[i];
            }
            if (2 <= 2 * i + 1 && 2 * i + 1 <= n){
                dp[2 * i + 1] = dp[i] + dp[i + 1];
            }
        }
        int max = 0;
        for (int i = 0; i <= n; i++){
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;

    }
}
