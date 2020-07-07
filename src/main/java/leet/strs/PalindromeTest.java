package leet.strs;

import org.junit.Test;

/**
 * desc: 回文串
 * author: liuxiaozheng
 * time: 2020/7/1  10:59
 **/
public class PalindromeTest {
    @Test
    public void test(){
        String strs = "A man, a plan, a canal: Panama";
//        String strs = "race a car";
        boolean result = isPalindrome(strs);
        System.out.println("");
        System.out.println(result);

    }

    public boolean isPalindrome(String str) {
        if (str == null){
            return false;
        }
        StringBuffer sBuffer = new StringBuffer();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c >= 97 && c <= 122 || c >= 65 && c <= 90 || c >= 48 && c <= 57){
                String s = c + "";
                sBuffer.append(s.toLowerCase());
            }
        }
        StringBuffer reverse = new StringBuffer(sBuffer).reverse();

        return sBuffer.toString().equals(reverse.toString());
    }
}
