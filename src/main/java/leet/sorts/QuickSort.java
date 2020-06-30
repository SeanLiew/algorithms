package leet.sorts;

import leet.utils.GsonUtils;

/**
 * desc: 快速排序
 * author: liuxiaozheng
 * time: 2020/6/24  10:00
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(GsonUtils.toJson(arr));
    }

    public static int[] quickSort(int[] arr, int left, int right){
        if (left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }

        return arr;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++){
            if (arr[i] < arr[pivot]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
