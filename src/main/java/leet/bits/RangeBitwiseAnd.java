package leet.bits;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-21 16:28
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        left <<= shift;
        return left;
    }

    @Test
    public void test2(){
        System.out.println(rangeBitwiseAnd(3, 5));
        //11
        //101
    }
}
