package leet.nums;

import org.junit.Test;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int i = n / 2;
        if (2 * i != n) {
            return false;
        }
        return isPowerOfTwo(i);
    }

    @Test
    public void test() {
        System.out.println(isPowerOfTwo(6));
    }
}
