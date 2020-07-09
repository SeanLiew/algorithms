package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * desc: 两数之和
 * author: liuxiaozheng
 * time: 2020/7/8  17:04
 **/
public class SumOfTwo {
    @Test
    public void test(){
        int[] arr = {-1, 0};
        int[] newArr = twoSum2(arr, -1);
        System.out.println(JSON.toJSON(newArr));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = i + 1; j < numbers.length; j ++){
                if (numbers[i] + numbers[j] == target){
                    arr[0] = ++i;
                    arr[1] = ++j;
                    return arr;
                }
            }
        }
        return arr;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int high = numbers.length - 1;
        int low = 0;
        while(true){
            int sum = numbers[high] + numbers[low];
            if (sum == target){
                return new int[]{++low, ++high};
            } else if (sum < target){
                low++;
            }
            else {
                high--;
            }
            if (high == low){
                break;
            }
        }
        return new int[]{};
    }
}
