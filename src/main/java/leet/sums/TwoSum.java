package leet.sums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                return new int[]{nums[low], nums[high]};
            }
            if (nums[low] + nums[high] > target) {
                high--;
            }
            if (nums[low] + nums[high] < target) {
                low++;
            }
        }
        return new int[]{};
    }

    @Test
    public void test(){
        int[] arr = {2,3,4};
        System.out.println(JSON.toJSONString(twoSum(arr, 6)));
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{0};
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            Integer leftIndex = map.get(left);
            if (leftIndex != null && leftIndex != i) {
                return new int[]{i, leftIndex};
            }
        }
        return new int[]{0};
    }

    @Test
    public void test2(){
        int[] arr = {3,2,4};
        System.out.println(JSON.toJSONString(twoSum2(arr, 6)));
    }

//    if (nums == null || nums.length < 2) {
//        return new int[]{0};
//    }
//    int low = 0;
//    int high = nums.length -1;
//        while (low < high) {
//        if (nums[low] + nums[high] == target) {
//            return new int[]{low, high};
//        }
//        if (nums[low] + nums[high] > target) {
//            high--;
//        }
//        if (nums[low] + nums[high] < target) {
//            low++;
//        }
//    }
//
//        return new int[]{0};

}
