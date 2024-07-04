package leet.nums;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-06-27 19:17
 */
public class CompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < gas.length; i++){
            sum = sum + gas[i] - cost[i];
            if(sum < min && sum < 0){
                min = sum;
                minIndex = i;
            }
        }
        if(sum < 0){
            return -1;
        }
        return (minIndex + 1 )%gas.length;
    }

    @Test
    public void test(){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};


        System.out.println(canCompleteCircuit(gas, cost));
    }
}
