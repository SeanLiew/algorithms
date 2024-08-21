package leet.strs;

import leet.utils.GsonUtils;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-20 21:04
 */
public class ReverseStringTest {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
    @Test
    public void test(){
        char[] arr = {'h','e','l','l','o'};
        System.out.println(GsonUtils.toJson(arr));
        reverseString(arr);
        System.out.println(GsonUtils.toJson(arr));
    }
}
