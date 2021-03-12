package leet.nums;

import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/12 14:35
 */
public class MissingNum {
    @Test
    public void test (){

        int[] arr0 = {0,1};
        int[] arr = {0,1,2,3,5,6,7};
        int[] arr2 = {1,2,3,4,5,6};


        System.out.println(missingNumber(arr0));
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber(arr2));
    }

    public int missingNumber(int[] nums) {

        int left = 0;

        int right = nums.length - 1;

        if (nums[right] < nums.length){
            return nums.length;
        }

        while(left < right){
            int mid = (left + right) / 2;

            if (nums[mid] > mid){
                right = mid;
            }

            if (nums[mid] == mid){
                left = mid + 1;
            }
        }
        return left;
    }
}
