package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2019/12/20  16:44
 **/
public class ArrayTest {



    @Test
    public void testSearch(){
        int[] arr = {1};
        int i = searchInsertMiddle(arr, 0);

        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target){
                return i;
            }
        }

        return nums.length;
    }
    public int searchInsertMiddle(int[] nums, int target) {
        int length = nums.length;

        if (length == 0){
            return 0;
        }

        if (nums[length - 1] < target){
            return nums.length;
        }

        int left = 0;

        int right = length - 1;

        while (true){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (right == left){
                return left;
            }
            if (right == left + 1){
                if (nums[left] > target){
                    return left;
                }
                return left + 1;
            }
            if (nums[mid] > target){
                right = mid;
            }
            if (nums[mid] < target){
                left = mid;
            }
        }
    }
}
