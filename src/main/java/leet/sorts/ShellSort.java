package leet.sorts;

import leet.utils.GsonUtils;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/6/23  10:43
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 63, 41, 60, 76, 18, 1, 3 ,4, 5, 6, 21,7, 54, 3, 23, 2, 12, 11, 90, 12, 43};
        sort(arr);
        System.out.println(GsonUtils.toJson(arr));
    }

    public static int[] sort(int[] arr){
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < len; i++){
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
}
