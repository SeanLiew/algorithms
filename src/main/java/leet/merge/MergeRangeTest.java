package leet.merge;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-22 18:59
 */
public class MergeRangeTest {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] result  = new int[intervals.length][];
        int resultIndex = 0;

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current == null) {
                continue;
            }
            int j = i + 1;
            while (j < intervals.length) {
                int[] next = intervals[j];
                if (next == null) {
                    j++;
                    continue;
                }
                //有重合
                if (current[1] >= next[0] && current[1] <= next[1] ||
                        next[1] >= current[0] && next[1] <= current[1]) {
                    //合并到current
                    current[0] = Math.min(current[0], next[0]);
                    current[1] = Math.max(current[1], next[1]);
                    //被合并的数组，置空
                    intervals[j] = null;
                }
                j++;
            }
            result[resultIndex++] = current;
        }
        if (resultIndex != result.length) {
            return Arrays.copyOfRange(result, 0, resultIndex);
        }
        return result;
    }


    public int[][] sort (int[][] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        int pindex = partition(arr, start, end);
        sort(arr, start, pindex - 1);
        sort(arr, pindex + 1, end);
        return arr;
    }

    public int partition(int[][] arr, int start, int end){
        int[] pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && pivot[0] < arr[right][0]) {
                right--;
            }
            while (left < right && pivot[0] >= arr[left][0]) {
                left++;
            }
            if (left < right) {
                //交换
                int[] temp = arr[right];
                arr[right] =  arr[left];
                arr[left] = temp;

            }
        }

        //交换重合处的
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }



    @Test
    public void test(){
        System.out.println(JSON.toJSON(sort(new int[][]{{4,5},{2,3},{6,7},{8,9},{1,10}}, 0 , 4)));
        System.out.println(JSON.toJSON(merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}})));
        System.out.println(JSON.toJSON(merge(new int[][]{{4,5}, {0,0}})));
        System.out.println(JSON.toJSON(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }

    @Test
    public void test2(){
        int[][] result  = new int[1][];
        int[] nums = {1,3};
        result[0] = nums;
        System.out.println(JSON.toJSON(result));
    }
}
