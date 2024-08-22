package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-22 21:42
 */
public class TwoSumTest {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
            if (sum == target) {
                return new int[]{left, right};
            }
        }
        return numbers;
    }

    @Test
    public void test3 (){
        int[] nums1 = {3,4,5,8};
        System.out.println(JSON.toJSON(twoSum(nums1, 9)));
    }
}
