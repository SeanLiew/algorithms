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
    public void test1 (){
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        merge(nums1, m ,nums2, n);
        System.out.println(JSON.toJSON(nums1));
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int a = m - 1;
        int b = n - 1;
        while (a >= 0 || b >= 0) {
            if (a >=0 && (b < 0 || nums1[a] > nums2[b])) {
                nums1[index--] = nums1[a];
                a--;
            }
            if (b >=0 && (a < 0 || nums1[a] <= nums2[b])) {
                nums1[index--] = nums2[b];
                b--;
            }
        }
    }


    @Test
    public void test2 (){
        int[] nums1 = {4,5,7,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,6};
        int n = 3;
        merge2(nums1, m ,nums2, n);
        System.out.println(JSON.toJSON(nums1));
    }

    public int[] merge3(int[] nums1, int[] nums2) {

        int [] result = new int[nums1.length + nums2.length];

        int a = 0;
        int b = 0;
        while(a < nums1.length || b < nums2.length) {
            if (a < nums1.length && (b == nums2.length || nums1[a] < nums2[b])) {
                result[a+b] = nums1[a];
                a++;
            }
            if (b < nums2.length && (a == nums1.length || nums1[a] >= nums2[b])) {
                result[a+b] = nums2[b];
                b++;
            }
        }

        return result;
    }


    @Test
    public void test3 (){
        int[] nums1 = {3,4,5,8};
        int[] nums2 = {1,2,6,7};
        System.out.println(JSON.toJSON(merge3(nums1,nums2)));
    }
}
