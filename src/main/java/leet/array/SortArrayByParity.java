package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-23 00:18
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] % 2;
            if (n == 0) {
                //偶数
                result[left++] = nums[i];
            } else {
                //奇数
                result[right--] = nums[i];
            }

        }
        return result;
    }

    @Test
    public void test(){
        int[] arr = {3,1,2,4};
        System.out.println(JSON.toJSON(sortArrayByParity(arr)));
    }
}
