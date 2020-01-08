package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/8  9:49
 **/
public class PlusOne {
    @Test
    public void test(){
        int[] arr = {9,0,9};
        int[] newArr = plusOne(arr);
        System.out.println(JSON.toJSON(newArr));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
                if (i == 0){
                    digits[i] = 1;
                    int[] newArr = Arrays.copyOf(digits, digits.length + 1);
                    return newArr;
                }
            }else{
                digits[i] = digits[i] + 1;
                return digits;
            }

        }
        return digits;
    }
}
