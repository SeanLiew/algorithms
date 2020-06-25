package leet.list;

import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * desc: 斐波那契数列
 * author: liuxiaozheng
 * time: 2020/6/24  14:37
 **/
public class Fibonacci {
    @Test
    public void test(){

        System.out.println(GsonUtils.toJson(generate(3)));
        System.out.println(GsonUtils.toJson(getRow(3)));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        result.add(Arrays.asList(1));
        if (numRows == 1){
            return result;
        }
        List<Integer> lastList = new ArrayList<>(Arrays.asList(1, 1));
        result.add(lastList);
        if (numRows == 2){
            return result;
        }
        for (int i = 0 ; i < numRows - 2; i++){
            int preNum = 0;
            List<Integer> tempList = new ArrayList<>();
            for (Integer num : lastList){
                int newNum = num + preNum;
                preNum = num;
                tempList.add(newNum);
            }
            tempList.add(preNum);
            result.add(tempList);
            lastList = tempList;
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = Arrays.asList(1);
        if (rowIndex == 0){
            return result;
        }
        result = Arrays.asList(1, 1);
        if (rowIndex == 1){
            return result;
        }
        for (int i = 0 ; i < rowIndex - 1; i++){
            int preNum = 0;
            List<Integer> tempList = new ArrayList<>();
            for (Integer num : result){
                int newNum = num + preNum;
                preNum = num;
                tempList.add(newNum);
            }
            tempList.add(preNum);
            result = tempList;
        }
        return result;
    }
}
