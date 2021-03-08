package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/8 17:27
 */
public class MaxNum {
    @Test
    public void test (){

        System.out.println(JSON.toJSONString(printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        int length = (int)Math.pow(10, n);
        length -= 1;
        int[] arr = new int[length];
        for (int i=0; i<length;i++){
            arr[i] = i+1;
        }

        return arr;
    }
}
