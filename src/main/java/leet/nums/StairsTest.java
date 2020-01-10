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
        int result = climbStairs(3);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp [i - 2];
        }

        return dp[n];

    }
}
