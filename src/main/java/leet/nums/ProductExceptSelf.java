package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-06-24 20:22
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left [i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result [i - 1];
        }
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * r;
            r = r * nums[i];
        }
        return result;
    }


    @Test
    public void testProductExceptSelf(){

        System.out.println(JSON.toJSONString(productExceptSelf2(new int[]{1,2,3,4})));
        System.out.println(JSON.toJSONString(productExceptSelf2(new int[]{-1,1,0,-3,3})));
    }
}
