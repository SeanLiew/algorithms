package leet.bits;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-19 21:17
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            sum += carry;
            if (indexA >= 0) {
                sum += Integer.valueOf(a.charAt(indexA--) + "");
            }
            if (indexB >= 0) {
                sum += Integer.valueOf(b.charAt(indexB--) + "");
            }
            if (sum >= 2) {
                carry = 1;
                sum = sum - 2;
            } else {
                carry = 0;
            }
            result.insert(0, sum);
            sum = 0;
        }
        return result.toString();

    }
    @Test
    public void test(){
        System.out.println(addBinary("1010", "1011"));
    }
}
