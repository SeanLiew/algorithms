package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (j >= m && nums1[j] == 0) {
                    nums1[j] = nums2[i];
                    break;
                }
                if (nums2[i] < nums1[j]) {
                    int temp = nums2[i];
                    nums2[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }

    }


    @Test
    public void test2 (){
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        merge(nums1, m ,nums2, n);
        System.out.println(JSON.toJSON(nums1));
    }
}
