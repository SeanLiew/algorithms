package leet.sums;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/8  10:24
 **/
public class BinarySum {
    @Test
    public void test(){
        String result = addBinary("1111", "1111");
        System.out.println(result);
    }
    public String addBinary(String a, String b) {
        int carry = 0;
        String result = "";
        int index = 1;

        while (true){
            int aSub = 0;
            int bSub = 0;
            if (index > a.length() && index > b.length()){
                break;
            }
            if (a.length() >= index){
                aSub = Integer.parseInt(a.charAt(a.length() - index) + "");
            }
            if (b.length() >= index){
                bSub = Integer.parseInt(b.charAt(b.length() - index) + "");
            }
            int sum = aSub + bSub + carry;

            if (sum > 1){
                result = (sum - 2) + result;
                carry = 1;
            } else{
                result = sum + result;
                carry = 0;
            }
            index++;
        }
        if (carry == 1){
            result = carry + result;
        }
        return result;
    }
}
