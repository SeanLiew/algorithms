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

}
