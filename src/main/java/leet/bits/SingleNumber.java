package leet.bits;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-21 16:09
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int re = 0;
        for (int num : nums) {
            re ^= num;
        }
        return re;
    }
    @Test
    public void test(){
        int[] nums = {1,1,2,4,2};
        System.out.println(singleNumber(nums));
    }
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i =0; i < 32; i++) {
            int ival = 0;
            for (int num : nums) {
                ival += (num >> i) & 1;
            }
            if (ival % 3 != 0) {
                res |= 1 << i;
            }

        }
        return res;
    }
    @Test
    public void test2(){
        int[] nums = {4,2,2,2,3,3,3};
        System.out.println(singleNumber2(nums));
    }
}
