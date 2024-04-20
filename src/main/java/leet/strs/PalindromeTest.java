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
    public boolean isPalindrome2(String str) {
        if (str == null){
            return false;
        }
        //c >= 97 && c <= 122

        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            int startChar = str.charAt(start);
            if (startChar >= 97 && startChar <= 122) {
                startChar = startChar - 32;
            }
            if (!(startChar >= 65 && startChar <= 90 || startChar >= 48 && startChar <= 57)) {
                start++;
                continue;
            }
            int endChar = str.charAt(end);
            if (endChar >= 97 && endChar <= 122) {
                endChar = endChar - 32;
            }
            if (!(endChar >= 65 && endChar <= 90 || endChar >= 48 && endChar <= 57)) {
                end--;
                continue;
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }




    @Test
    public void test2(){
        System.out.println(isPalindrome2("Ab` a"));
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2("race a car"));

    }
}
