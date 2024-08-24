package leet.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int insertedIndex = -1;
        boolean findPosition = false;
        int mergedInterval = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= newInterval[0] && newInterval[0] <= current[1]
                || newInterval[0] <= current[0] && current[0] <= newInterval[1] ) {
                //记录插入位置
                insertedIndex = i;
                //记录找到位置了
                findPosition = true;
                newInterval[0] = Math.min(current[0], newInterval[0]);
                newInterval[1] = Math.max(current[1], newInterval[1]);
                //置空
                intervals[i] = null;
                mergedInterval++;
            } else {
                //如果找到过位置，后面不存在重合，就不需要继续遍历了
                if (findPosition) {
                    break;
                }
            }
        }
        if (findPosition) {
            intervals[insertedIndex] = newInterval;
            int[][] result = new int[intervals.length - mergedInterval + 1][];
            int pos = 0;
            for (int[] current : intervals) {
                if (current != null) {
                    result[pos++] = current;
                }
            }
            return result;
        } else {
            //没有找到,新建一个数组，合并
            int[][] result = new int[intervals.length + 1][];
            int pos = 0;
            //原数组下标
            int index = 0;
            //是否已经将区间插入了
            boolean inserted = false;
            for (int i = 0; i < result.length; i++) {
                if (index < intervals.length) {
                    if (inserted) {
                        result[pos++] = intervals[index++];
                        continue;
                    }
                    int[] current = intervals[index];
                    if (current[0] < newInterval[0]) {
                        result[pos++] = current;
                        index++;
                    } else {
                        result[pos++] = newInterval;
                        inserted = true;
                    }
                } else {
                    //超出二维数组长度了，直接插入区间
                    result[pos++] = newInterval;
                    inserted = true;
                }
            }

            return result;
        }
    }
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            //在当前节点右侧
            if (newInterval[0] > current[1]) {
                //把当前节点加入
                ansList.add(current);
            } else if (newInterval[1] < current[0]){
                //在当前节点左侧,先把新区间加入
                if (!placed) {
                    ansList.add(newInterval);
                    placed = true;
                }
                //再把当前加入
                ansList.add(current);
            }else {
                //存在交叉
                newInterval[0] = Math.min(newInterval[0], current[0]);
                newInterval[1] = Math.max(newInterval[1], current[1]);
            }
        }
        if (!placed) {
            ansList.add(newInterval);
        }
        int[][] result = new int[ansList.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = ansList.get(i);
        }
        return result;

    }

    @Test
    public void test (){
//        int[][] nums1 = {{1,3},{6,9}};
//        int[] nums2 = {2,5};
//        int[][] nums1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] nums2 = {4,8};
//        int[][] nums1 = {{1,2},{6,8}};
//        int[] nums2 = {3,4};
//        int[][] nums1 = {};
//        int[] nums2 = {3,4};
        int[][] nums1 = {{5,6}};
        int[] nums2 = {3,4};

        int[][] insert = this.insert2(nums1, nums2);
        System.out.println(JSON.toJSONString(insert));
    }
}
