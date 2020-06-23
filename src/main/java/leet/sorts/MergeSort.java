package leet.sorts;

import leet.utils.GsonUtils;

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
}
