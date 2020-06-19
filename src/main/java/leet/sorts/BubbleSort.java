package leet.sorts;

import leet.utils.GsonUtils;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/6/19  14:45
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        sort(arr);
        System.out.println(GsonUtils.toJson(arr));
    }

    public static int[] sort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
