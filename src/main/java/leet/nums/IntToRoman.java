package leet.nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-06-27 19:30
 */
public class IntToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(900);
        list.add(500);
        list.add(400);
        list.add(100);
        list.add(90);
        list.add(50);
        list.add(40);
        list.add(10);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(1);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Integer listNum = list.get(i);
            if (num >= listNum) {
                int count = num / listNum;
                for (int c = 0; c < count; c++) {
                    stringBuilder.append(map.get(listNum));
                }
                num = num - count *listNum;
            }
        }

        return stringBuilder.toString();
    }
    @Test
    public void test(){
        System.out.println(intToRoman(1994));
    }
}
