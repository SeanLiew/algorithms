package leet.nums;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-04-24 12:21
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }

        int left = 0;
        int right = 0;
        int minStep = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minStep = Math.min(minStep, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }
        return minStep == Integer.MAX_VALUE ? 0 : minStep;
    }

    @Test
    public void test1(){
        System.out.println(minSubArrayLen(11, new int[] {1,2,3,4,5}));
        System.out.println(minSubArrayLen(11, new int[] {1,1,1}));
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[] {1,4,4}));
    }
}
