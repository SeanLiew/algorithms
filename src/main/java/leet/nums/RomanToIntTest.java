package leet.nums;

import org.junit.Test;

public class RomanToIntTest {
    @Test
    public void testRomanToInt (){

        int result = romanToInt("MCMXCIV");


        System.out.println(result);
    }


    public int romanToInt(String remos) {

        int result = 0;

        if (remos == null){
            return result;
        }

        for (int i=0; i < remos.length(); i++){
            char c = remos.charAt(i);

            int currentInt = this.sigleChar2Int(c);

            if (i == remos.length() - 1){
                result += currentInt;
                return result;
            }

            char nextChar = remos.charAt(i + 1);

            int nextInt = this.sigleChar2Int(nextChar);

            if (currentInt >= nextInt){
                result += currentInt;
            } else{
                result -= currentInt;
            }

        }
        return result;
    }


    private int sigleChar2Int(char c){
        switch (c){
            case 'M':
                return  1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    @Test
    public void testRomanToInt2(){

        System.out.println(romanToInt2("MCMXCIV"));
        System.out.println(romanToInt2("III"));
    }


    public int romanToInt2(String remos) {
        if (remos == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < remos.length(); i++) {
            char c = remos.charAt(i);
            int currentInt = sigleChar2Int(c);
            if (i == remos.length() - 1) {
                return result + currentInt;
            }

            int nextInt = sigleChar2Int(remos.charAt(i + 1));
            if (nextInt > currentInt) {
                result = result - currentInt;
            } else {
                result = result + currentInt;
            }
        }
        return result;
    }
}
