package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-21 09:49
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length <= 1) {
            return arr1;
        }
        int current = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = current; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    int temp = arr1[current];
                    arr1[current] = arr1[j];
                    arr1[j] = temp;
                    current++;
                }
            }
        }
        if (current < arr1.length - 1) {
            quickSort2(arr1, current, arr1.length - 1);
        }
        return arr1;
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
    public void test(){
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        int[] ints = relativeSortArray(arr1, arr2);

        System.out.println(JSON.toJSONString(ints));
    }


}
