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
        int[] arr = {1};
        int i = majorityElement(arr);

        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums){
            Integer cache = map.get(num);
            if (cache == null){
                map.put(num, 1);
                continue;
            }
            if (++cache > nums.length / 2){
                return num;
            }
            map.put(num, cache);
        }
        return 0;
    }
}
