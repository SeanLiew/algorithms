package leet.bimethod;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-22 19:44
 */
public class SearchRange {
    public int[] searchRange2(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
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
        int[] res = {-1, -1};
        if (index != -1) {
            int right = index;
            int left = index;
            while (left > 0 && nums[left] == nums[left - 1]) {
                left--;
            }
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right++;
            }
            res[0] = left;
            res[1] = right;
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int first = findFirstPos(nums, target);
        if (first == -1) {
            return new int[]{-1,-1};
        }
        int last = findLastPos(nums, target);
        return new int[]{first, last};
    }

    private int findFirstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
    private int findLastPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    @Test
    public void testSearch(){
        int[] arr = {2,2};

        System.out.println(JSON.toJSONString(searchRange(arr, 8)));
    }
}
