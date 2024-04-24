package leet.nums;

import org.junit.Test;

public class IsPalindrome {
    @Test
    public void testIsPalindrome (){

        boolean result = isPalindrome(1221);


        System.out.println(result);
    }

    public boolean isPalindrome(int original) {
        if (original < 0) {
            return false;
        }
        if (original < 10 || original == 0) {
            return true;
        }
        if (original % 10 == 0) {
            return false;
        }
        int result = 0;
        int left = original;
        while (true) {
            int last = left % 10;
            left = left / 10;
            result = result * 10 + last;
            if (left == result) {
                return true;
            }
            if (left == 0) {
                return result == original;
            }
        }
    }
    public boolean isPalindrome2(int original) {

        if (original < 0){
            return false;
        }
        if (original < 10 || original == 0){
            return true;
        }
        if (original % 10 == 0){
            return false;
        }

        int result = 0;

        while (true){
            int last = original % 10;

            if (result * 10 > original){
                return false;
            }

            result = result * 10 + last;

            if (result == original){
                return true;
            }

            original = original / 10;

            if (result == original){
                return true;
            }
        }
    }
}
