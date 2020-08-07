package leet.nums;

import org.junit.Test;

import java.math.BigInteger;

/**
 * desc: 阶乘后的0
 * author: liuxiaozheng
 * time: 2020/8/6  9:58
 **/
public class TrailingZeroes {
    @Test
    public void test(){

        int revert = trailingZeroes4(30);


        System.out.println(revert);
    }

    public int trailingZeroes(int n) {
        BigInteger result = new BigInteger("1");
        int zeroCount = 0;
        while(n > 0){
            result = result.multiply(BigInteger.valueOf(n));
            n--;
            if (result.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
                zeroCount++;
                result = result.divide(BigInteger.TEN);
            }
        }
        return zeroCount;
    }
    public int trailingZeroes2(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i++){
            int  current = i;
            while(current % 5 == 0){
                zeroCount++;
                current = current / 5;
            }

        }
        return zeroCount;
    }
    public int trailingZeroes3(int n) {
        int zeroCount = 0;
        int currentMultiple = 5;
        while (n >= currentMultiple){
            zeroCount += n / currentMultiple;
            currentMultiple *= 5;

        }
        return zeroCount;
    }

    public int trailingZeroes4(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
