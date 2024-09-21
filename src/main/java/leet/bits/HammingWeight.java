package leet.bits;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-21 15:57
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(hammingWeight(4));
    }
}
