package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

public class TwoArraySort {

    @Test
    public void test(){
        int[] arr1 = {2, 3, 5, 0, 0, 0};
        int[] arr2 = {1, 4, 6};
        reverseMerge(arr1, 3, arr2, 3);

        System.out.println(JSON.toJSON(arr1));
    }

    private void reverseMerge(int[] arr1, int size1, int[] arr2, int size2) {

        int end1 = size1 - 1;
        int end2 = size2 - 1;
        int dest = arr1.length - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (arr1[end1] > arr2[end2]) {
                arr1[dest--] = arr1[end1--];
            } else {
                arr1[dest--] = arr2[end2--];
            }
        }
        while (end2 >= 0) {
            arr1[dest--] = arr2[end2--];
        }
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;

        int smallDiff = Integer.MAX_VALUE;
        while (p1 <a.length && p2<b.length) {
            long la = (long)a[p1];
            long lb = (long)b[p2];
            smallDiff = (int)Math.min(smallDiff, Math.abs(la - lb));
            if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return smallDiff;

    }


    @Test
    public void test2 (){
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        System.out.println(smallestDifference(nums1, nums2));
    }
}
