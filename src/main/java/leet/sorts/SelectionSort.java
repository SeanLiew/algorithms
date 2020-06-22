package leet.sorts;

import leet.utils.GsonUtils;

/**
 * desc: 选择排序
 * author: liuxiaozheng
 * time: 2020/6/19  15:17
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        sort(arr);
        System.out.println(GsonUtils.toJson(arr));
    }

    public static int[] sort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < len; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
