package leet.bits;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-21 17:34
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        ArrayList<Integer>[] arr = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = new ArrayList();
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            indeg[course]++;
            arr[prereq].add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[index++] = poll;
            ArrayList<Integer> arrayList = arr[poll];
            for (int i : arrayList) {
                if (--indeg[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }

    @Test
    public void test() {
        //0 -> 1 -> 3
        //2 -> 1 -> 4

        int[][] matrix = new int[1][2];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
//        matrix[1][0] = 2;
//        matrix[1][1] = 1;
        System.out.println(JSON.toJSONString(findOrder(2, matrix)));

    }
}
