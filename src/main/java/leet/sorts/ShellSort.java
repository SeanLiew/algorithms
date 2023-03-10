package leet.sorts;

import leet.utils.GsonUtils;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/6/23  10:43
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {60, 12, 63, 41, 50, 76, 18, 1};
        //gap = 4
        //50, 12, 63, 41, 60, 76, 18, 1
        //50, 12, 63, 41, 60, 76, 18, 1
        //50, 12, 18, 41, 60, 76, 63, 1 cur = 18
        //50, 12, 18, 1, 60, 76, 63, 41 cur = 1
        //gap = 2
        //18, 12, 50, 1, 60, 76, 63, 41 cur = 18
        //18, 1, 50, 12, 60, 76, 63, 41 cur = 1
        //18, 1, 50, 12, 60, 76, 63, 41 cur = 60
        //18, 1, 50, 12, 60, 76, 63, 41 cur = 76 j =5
        //18, 1, 50, 12, 60, 76, 63, 41 cur = 63 j =6
        //18, 1, 50, 12, 60, 76, 63, 76 cur = 41 j =7
        //18, 1, 50, 12, 60, 41, 63, 76 cur = 41 j =5
        //gap=1
        //1, 18, 50, 12, 60, 41, 63, 76 cur = 18 j =1
        //1, 18, 50, 12, 60, 41, 63, 76 cur = 50 j =2
        //1, 12, 18, 50, 60, 41, 63, 76 cur = 12 j =3
        //1, 12, 18, 50, 60, 41, 63, 76 cur = 60 j =4
        //1, 12, 18, 41, 50, 60, 63, 76 cur = 41 j =5
        //1, 12, 18, 41, 50, 60, 63, 76 cur = 63 j =6
        //1, 12, 18, 41, 50, 60, 63, 76 cur = 63 j =7

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
