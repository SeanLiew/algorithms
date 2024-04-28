package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int carry = 1;
        while (index >= 0) {
            int nextVal = digits[index] + carry;
            carry = nextVal / 10;
            digits[index] = nextVal % 10;
            index--;
        }
        if (digits[0] != 0) {
            return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(plusOne(new int []  {9,9})));
    }
}
