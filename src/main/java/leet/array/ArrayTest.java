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
    public void test(){
        int[] arr = {1,1,2,2,4,5,5,6,7,7,8};
        int i = removeDuplicates(arr);

        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {

        int result = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[result]){
                nums[++result] = nums[i];
            }
        }

        return result + 1;
    }

    @Test
    public void test2(){
        int[] arr = {3,2,2,3};
        int i = removeElement(arr, 3);

        System.out.println(i);


    }

    public int removeElement(int[] nums, int val) {
        int result = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[result++] = nums[i];
            }
        }

        System.out.println(JSON.toJSON(nums));


        return result;
    }

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
