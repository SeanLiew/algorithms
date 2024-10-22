package leet.bimethod;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-22 19:12
 */
public class SearchInCircle {
    public int search2(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
            }
        }
        if (index == -1) {
            return search(nums, 0, nums.length - 1, target);
        }
        if (target >= nums[0] && target <= nums[index]){
            return search(nums, 0, index, target);
        }
        return search(nums, index + 1, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            if (nums[mid] > target) {
                end = mid - 1;
                continue;
            }
            if (nums[mid] < target) {
                start = mid + 1;
                continue;
            }
        }
        return -1;
    }



    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void testSearch(){
        int[] arr = {4,5,6,7,0,1};
        int i = search(arr, 1);

        System.out.println(i);
    }
}
