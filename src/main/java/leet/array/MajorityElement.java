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
        System.out.println(majorityElement(new int[] {4,2,2,4,2}));
        System.out.println(majorityElement(new int[] {4,2,4,4,4,5,5}));
    }

    public int majorityElement(int[] nums) {
        int curNum = nums[0];
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                curNum = nums[i];
            }
            vote += (curNum == nums[i]) ? 1 : -1;
        }
        return curNum;
    }


}
