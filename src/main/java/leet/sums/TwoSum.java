package leet.sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * desc: 两数之和
 * author: liuxiaozheng
 * time: 2020/7/9  14:42
 **/
public class TwoSum {

    List<Integer> list;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (list.size() == 0 || list.size() == 1){
            return false;
        }
        Collections.sort(list);
        int low = 0;
        int high = list.size() - 1;
        while (true){
            int sum = list.get(low) + list.get(high);
            if (sum == value){
                return true;
            } else if(sum < value){
                low++;
            } else {
                high--;
            }
            if (high == low){
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(3);
        obj.add(1);
        obj.add(2);
        boolean find = obj.find(3);
        System.out.println(find);
    }
}
