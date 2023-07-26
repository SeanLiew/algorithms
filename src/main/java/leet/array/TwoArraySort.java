package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class TwoArraySort {

    @Test
    public void test(){
        int[] arr1 = {2, 3, 5, 0, 0, 0};
        int[] arr2 = {1, 4, 6};
        reverseMerge(arr1, 3, arr2, 3);

        System.out.println(JSON.toJSON(arr1));
    }

    private void reverseMerge(int[] arr1, int size1, int[] arr2, int size2) {

        int end1 = size1 - 1;
        int end2 = size2 - 1;
        int dest = arr1.length - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (arr1[end1] > arr2[end2]) {
                arr1[dest--] = arr1[end1--];
            } else {
                arr1[dest--] = arr2[end2--];
            }
        }
        while (end2 >= 0) {
            arr1[dest--] = arr2[end2--];
        }
    }
}
