package leet.bimethod;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class FindMinTest {
    public int findMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] < nums[1] ? nums[0] : nums[1];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == nums.length - 1) {
                return nums[mid];
            }
            if (mid == 0) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                left = mid + 1;
                continue;
            }
            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                if (nums[0] < nums[mid] && nums[mid] > nums[nums.length - 1]) {
                    left = mid + 1;
                    continue;
                }
                if (nums[0] > nums[mid] && nums[mid] < nums[nums.length - 1]) {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] < nums[right]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }
    @Test
    public void test1(){
        int[] arr5 = {4,5,6,7,0,1,2};
        System.out.println(JSON.toJSONString(findMin(arr5)));
        int[] arr0 = {2,3,1};
        System.out.println(JSON.toJSONString(findMin(arr0)));
        int[] arr = {3,4,5,1,2};
        System.out.println(JSON.toJSONString(findMin(arr)));
        int[] arr1 = {4,5,6,7,0,1};
        System.out.println(JSON.toJSONString(findMin(arr1)));
        int[] arr2 = {7,0,1,2,3,4};
        System.out.println(JSON.toJSONString(findMin(arr2)));
        int[] arr3 = {7,0,1,2,3,4,6};
        System.out.println(JSON.toJSONString(findMin(arr3)));
        int[] arr4 = {2,1};
        System.out.println(JSON.toJSONString(findMin(arr4)));
    }
}
