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
            return nums[0] == target ? 1 : 0;
        }

        int left = 0;
        int right = 0;
        int minStep = 0;
        while (left < nums.length) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            if (sum >= target) {
                if (minStep == 0) {
                    minStep = right - left + 1;;
                } else{
                    minStep = Math.min(minStep, right - left + 1);
                }
            }

            if (sum >= target) {
                left++;
            }
            if (sum < target) {
                if (right < nums.length - 1) {
                    right++;
                } else {
                    break;
                }
            }
        }
        return minStep;
    }

    @Test
    public void test1(){
        System.out.println(minSubArrayLen(11, new int[] {1,2,3,4,5}));
        System.out.println(minSubArrayLen(11, new int[] {1,1,1}));
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[] {1,4,4}));
    }
}
