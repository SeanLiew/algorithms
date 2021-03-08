package leet.nums;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/10  11:25
 **/
public class StairsTest {
    @Test
    public void test(){
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++){
            dp[i] = (dp[i - 1] + dp[i - 2])  % 1000_000_007;
        }

        return dp[n];

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
}
