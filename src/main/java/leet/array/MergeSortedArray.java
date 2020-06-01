package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/10  14:27
 **/
public class MergeSortedArray {
    @Test
    public void test(){
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {1 ,4, 6};
//        int[] arr1 = {0,0,0};
//        int[] arr2 = {1,2,3};
//        int[] arr1 = {2,0};
//        int[] arr2 = {1};
        merge(arr1, 3, arr2, 3);

        System.out.println(JSON.toJSONString(arr1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++){
            int insert = nums2[i];
            for(int j = m; j >= 0; j--){
                if (j == 0){
                    nums1[j] = insert;
                    break;
                }else if (insert >= nums1[j-1]) {
                    nums1[j] = insert;
                    break;
                } else {
                    nums1[j] = nums1[j-1];
                    nums1[j-1] = 0;
                }
            }
            m++;
        }

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
