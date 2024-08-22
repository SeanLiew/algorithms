package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-22 21:47
 */
public class IsPossibleToSplitTest {
    public boolean isPossibleToSplit(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        Arrays.sort(nums);
        int[] arr1 = new int[nums.length / 2];
        int[] arr2 = new int[nums.length / 2];
        int p1 = 0;
        int p2 = 0;
        //先放数组1
        arr1[p1++] = nums[0];
        arr2[p2++] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                //偶数放数组1
                if (nums[i] == arr1[p1 - 1]) {
                    return false;
                }
                arr1[p1++] = nums[i];
            } else {
                if (nums[i] == arr2[p2 - 1]) {
                    return false;
                }
                arr2[p2++] = nums[i];
            }
        }
        return true;
    }

    @Test
    public void test3 (){
        int[] nums1 = {10,7,10,8,8,8};
        System.out.println(JSON.toJSON(isPossibleToSplit(nums1)));
    }
}
