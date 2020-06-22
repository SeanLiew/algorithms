package leet.sorts;

import leet.utils.GsonUtils;

/**
 * desc:  插入排序
 * author: liuxiaozheng
 * time: 2020/6/19  15:24
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 1, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        sort2(arr);
        System.out.println(GsonUtils.toJson(arr));
    }

    public static int[] sort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++){
            int insert = arr[i];
            b: for (int j = i - 1; j >= 0; j--){
                if (insert < arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = insert;
                } else{
                    arr[j + 1] = insert;
                    break b;
                }
            }
        }
        return arr;
    }
    public static int[] sort2(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++){
            int insert = arr[i];
            int insertIndex = i;
            while (insertIndex > 0 && arr[insertIndex - 1] > insert){
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            arr[insertIndex] = insert;
        }
        return arr;
    }
}
