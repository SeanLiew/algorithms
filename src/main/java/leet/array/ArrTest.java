package leet.array;

import com.alibaba.fastjson.JSON;
import com.sun.tools.javac.util.List;
import org.junit.Test;

public class ArrTest {

    @Test
    public void test(){
        System.out.println(convert("PAYPALISHIRING", 3));
    }



    public String convert(String s, int numRows) {
        if (s.length()==1) return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i=0;i<stringBuilders.length;i++){
            stringBuilders[i] = new StringBuilder();
        }
        int length = s.length();
        int index = 0;
        int row = 0;
        while (index < length) {
            while (index < length && row < numRows) {
                char ch = s.charAt(index++);
                stringBuilders[row].append(ch);
                row++;
            }
            if (index == length) {
                break;
            }
            row -= 2;
            while (index < length && row > -1) {
                char ch = s.charAt(index++);
                stringBuilders[row].append(ch);
                row--;
            }
            row += 2;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : stringBuilders){
            result.append(sb.toString());
        }

        return result.toString();
    }

    @Test
    public void test2 (){
        var i = "555";
        System.out.println(i);
        var of = List.of("1", "2");

    }
}
