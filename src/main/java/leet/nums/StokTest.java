package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class StokTest {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for (int i=0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }


    @Test
    public void test1 (){
        int[] nums1 = {4,5,6,1,7,8};
        System.out.println(maxProfit(nums1));
    }


    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i=1; i<prices.length; i++) {
            dp[i][0] = Math.max(dp[i -1][0], dp[i -1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i -1][1], dp[i -1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit2_2(int[] prices) {

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for (int i=1; i<prices.length; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;

        }
        return preCash;
    }
    public int maxProfit2_3(int[] prices) {

        int profit = 0;

        for (int i=1; i<prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) {
                profit += diff;
            }

        }
        return profit;
    }


    @Test
    public void test2 (){
        int[] nums1 = {1,4,6,7,8};
        System.out.println(maxProfit2(nums1));
        System.out.println(maxProfit2_2(nums1));
        System.out.println(maxProfit2_3(nums1));
    }
}
