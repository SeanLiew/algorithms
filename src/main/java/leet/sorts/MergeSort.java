package leet.sorts;

import com.alibaba.fastjson.JSON;
import leet.utils.GsonUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/6/23  16:54
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        int[] sort = sort(arr);
        System.out.println(GsonUtils.toJson(sort));


    }

    public static int[] sort(int[] arr){
        int length = arr.length;
        if (length < 2){
            return arr;
        }
        int middle = length / 2;
        return merge(sort(Arrays.copyOfRange(arr, 0, middle)), sort(Arrays.copyOfRange(arr, middle, length)), length);
    }
    private static int[] merge(int[] left, int[] right, int length){
        int[] result = new int[length];

        int leftPointer = 0;
        int rightPointer = 0;

        int resultPointer = 0;

        while(leftPointer < left.length && rightPointer < right.length){
            if (left[leftPointer] <= right[rightPointer]){
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        while(leftPointer < left.length){
            result[resultPointer++] = left[leftPointer++];
        }
        while(rightPointer < right.length){
            result[resultPointer++] = right[rightPointer++];
        }

        return result;

    }


    @Test
    public void test(){
        int[] arr2 = {5,1,1,2,0,0};
        int[] sort = sort(arr2, 0, arr2.length - 1);

        System.out.println(JSON.toJSONString(sort));
    }

    public int[] sort(int[] arr,int left, int right){
        if (right == left) {
            return new int[]{arr[left]};
        }
        int mid = left + (right - left) / 2;
        int[] sort1 = sort(arr, left, mid);
        int[] sort2 = sort(arr, mid + 1, right);
        return merge(sort1, sort2);
    }

    //1，1，5，0，0，2

    public int[] merge(int[] arr1, int[] arr2) {
        int [] newArr = new int[arr1.length + arr2.length];
        int p = 0;

        int p1 = 0;
        int p2 = 0;
        while (p1 < arr1.length || p2 < arr2.length) {
            if (p1 < arr1.length && (p2 >= arr2.length || arr1[p1] <= arr2[p2])) {
                newArr[p++] = arr1[p1++];
            }
            if (p2 < arr2.length && (p1 >= arr1.length || arr1[p1] > arr2[p2])) {
                newArr[p++] = arr2[p2++];
            }
        }
        return newArr;
    }
}
