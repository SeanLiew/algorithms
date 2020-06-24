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
        sort(arr);
        System.out.println(GsonUtils.toJson(arr));
    }

    public static int[] sort(int[] arr){
        return arr;
    }
}
