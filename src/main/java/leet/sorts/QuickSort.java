package leet.sorts;

import com.alibaba.fastjson.JSON;
import leet.utils.GsonUtils;
import org.junit.Test;

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









    public static int[] quickSort2(int[] arr, int start, int end){
        if (start >= end) {
            return arr;
        }
        int partitionIndex = partition2(arr, start, end);
        quickSort2(arr, start, partitionIndex - 1);
        quickSort2(arr, partitionIndex + 1, end);
        return arr;
    }

    public static int partition2(int[] arr, int start, int end){
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //交换pivot原位置和重合点
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3,7,4,5,6,5,3,3,2,3,1,5,6};
//        int[] arr = {-2,1,-3, 7};
        quickSort2(arr, 0, arr.length - 1);

        System.out.println(JSON.toJSONString(arr));
    }
}
