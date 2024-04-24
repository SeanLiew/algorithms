package leet.nums;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2019/12/19  10:34
 **/
public class NumbersTest {
    @Test
    public void test (){

        System.out.println(-19 % 10);

        int revert = revert(-123);


        System.out.println(revert);
    }


    private int revert(int original){

        int result = 0;

        while (original != 0){
            int last = original % 10;

            if (result > Integer.MAX_VALUE / 10  || (result == Integer.MAX_VALUE / 10 && last > 7)){
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10  || (result == Integer.MIN_VALUE / 10 && last < -8)){
                return 0;
            }


            result = result * 10 + last;

            original = original / 10;
        }

        return result;
    }

    @Test
    public void testIsPalindrome (){

        boolean result = isPalindrome(12210);


        System.out.println(result);
    }

    public boolean isPalindrome(int original) {

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

    @Test
    public void testCountAndSay (){

        String result = countAndSay(5);


        System.out.println(result);
    }

    public String countAndSay(int n) {

        String first = "1";

        for (int i = 1; i < n; i++){
            first = countAndSaySub(first);
        }

        return first;
    }

    public String countAndSaySub(String input) {

        String output = "";
        for (int i = 0; i < input.length(); ){
            int count = 0;
            int k = i;
            Character c = input.charAt(i);
            while (k < input.length() && c.equals(input.charAt(k))){
                count++;
                k++;
            }
            output += count + c.toString();

            i = k;
        }

        return output;
    }
}
