package leet.search;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Desc:
 * @Author: Sean
 * @Date: 2021/3/11 14:55
 */
public class BinarySearch {
    @Test
    public void test (){

        int[] arr = {1,2,2,4,5,6,7};


        System.out.println(search(arr, 1));
    }
    public int search(int[] nums, int target) {

        int left = 0;

        int right = nums.length;

        int count = 0;

        while (left < right){
            int mid = (left + right) / 2;

            if (nums[mid] >= target){
                right = mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
        }
        while (left < nums.length){
            if (nums[left++] == target){
                count++;
            } else {
                break;
            }
        }
        return count;
    }

}
