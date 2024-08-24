package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] current : points) {
            if (list.size() == 0) {
                list.add(current);
                continue;
            }
            //取list中最后一个
            int[] last = list.get(list.size() - 1);
            if (last[1] >= current[0]) {
                //取交集
                last[0] = Math.max(last[0], current[0]);
                last[1] = Math.min(last[1], current[1]);
            } else {
                list.add(current);
            }
        }
        return list.size();
    }

    @Test
    public void test (){
//        int[][] nums1 = {{1,6},{3,9}};
//        int[][] nums1 = {{10,16},{2,8},{1,6},{7,12}};
        int[][] nums1 = {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[}[] nums1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[][] nums1 = {{1,2},{6,8}};
//        int[][] nums1 = {};
//        int[][] nums1 = {{5,6}};

        int minArrowShots = this.findMinArrowShots(nums1);
        System.out.println(minArrowShots);
    }
}
