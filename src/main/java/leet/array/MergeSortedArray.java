package leet.array;

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
        int[] arr2 = {2 ,4, 6};
        merge(arr1, 3, arr2, 3);

        System.out.println(arr1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = 0;

        for(int i = 0; i < n; i++){
            int insert = nums2[i];
            if (insert >= nums1[pointer]){
                continue;
            }
            while(true){


            }
        }

    }
}
