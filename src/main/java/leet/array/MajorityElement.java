package leet.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 多数元素
 * author: liuxiaozheng
 * time: 2020/7/9  14:17
 **/
public class MajorityElement {
    @Test
    public void test(){
        int[] arr = {4,2,4,4,4,5,5};
        int i = majorityElement(arr);

        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        int curNum = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++){
            if (curNum == nums[i]){
                vote++;
            } else {
                vote--;
                if (vote == 0){
                    curNum = nums[i + 1];
                }
            }
        }
        return curNum;
    }
}
