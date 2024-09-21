package leet.bits;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2021-11-12 3:17 下午
 */
public class ReverseBits {
    @Test
    public void test(){
        System.out.println(reverseBits(3));

    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0 & n !=0; i--) {
            res += (n & 1) << i;
            n = n >>> 1;
        }
        return res;
    }

}
