package leet.nums;

import leet.link.ListNode;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 17:17
 */
public class BinaryNum {

    @Test
    public void test (){

        System.out.println(hammingWeight(7));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += n&1;
            n = n >>> 1;
        }

        return res;

    }

}
