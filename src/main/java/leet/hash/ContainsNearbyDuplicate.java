package leet.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-04-24 11:17
 */
public class ContainsNearbyDuplicate {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer preIndex = map.get(nums[i]);
            if (preIndex != null && i - preIndex <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }



    @Test
    public void test1(){
        int[] num = {1,3,0,1,4};

        System.out.println(containsNearbyDuplicate(num, 2));
    }
}
