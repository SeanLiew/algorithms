package leet.array;

import org.junit.Test;

/**
 * desc: 买卖股票的最佳时机 II
 * author: liuxiaozheng
 * time: 2020/6/28  16:34
 **/
public class MaxProfit {
    @Test
    public void test(){
//        int[] arr = {1,-1,2,2,-8,5,5,6,7,-1,8};
        int[] arr = {-2,1,-3, 7};
        int i = maxProfit2(arr);

        System.out.println(i);
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                max = max + prices[i] - prices[i - 1];
            }
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int[] prices, int s) {
        if (s > prices.length){
            return 0;
        }

        int max = 0;
        for (int start = s; start < prices.length ; start++){
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++){
                if (prices[start] < prices[i]){
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit){
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max){
                max = maxProfit;
            }
        }
        return max;
    }


    public int maxProfit3(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int profit = 0, cost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }

    @Test
    public void test3(){
        int[] arr = {7,1,5,3,6,4};
        int i = maxProfit3(arr);

        System.out.println(i);
    }

    public int maxProfit4(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    @Test
    public void maxProfit4(){
        int[] arr = {7,1,5,3,6,4};
        int i = maxProfit4(arr);

        System.out.println(i);
    }
}
