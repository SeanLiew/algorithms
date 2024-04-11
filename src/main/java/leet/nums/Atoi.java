package leet.nums;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Atoi {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> numsSet = new HashSet<>();
        numsSet.add('0');
        numsSet.add('1');
        numsSet.add('2');
        numsSet.add('3');
        numsSet.add('4');
        numsSet.add('5');
        numsSet.add('6');
        numsSet.add('7');
        numsSet.add('8');
        numsSet.add('9');
        boolean isNegative = false;
        int result = 0;
        int startIndex = 0;
        while (startIndex < s.length() && s.charAt(startIndex) == ' ') {
            startIndex++;
        }
        if (startIndex == s.length()) {
            return 0;
        }
        if (s.charAt(startIndex) == '-') {
            isNegative = true;
        }
        if (s.charAt(startIndex) == '-' || s.charAt(startIndex) == '+') {
            startIndex++;
        }
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            if (numsSet.contains(c)) {
                int newResult = result * 10 + (c - '0');
                if (newResult/10 + (c - '0')  < result) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
                result = newResult;
            } else {
                break;
            }
        }
        if (isNegative) {
            return -result;
        }
        return result;

    }
    @Test
    public void test (){
        System.out.println(myAtoi("  -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("+2"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("-12147483648"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-6147483648"));
        System.out.println(myAtoi(" "));
    }
    @Test
    public void test2 (){
        System.out.println(Character.isDigit("12".charAt(0)));;
        System.out.println('1'-'0');
    }

}
