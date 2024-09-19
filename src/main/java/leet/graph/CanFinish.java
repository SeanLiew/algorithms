package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-09-18 18:58
 */
public class CanFinish {

    int[] visiting;
    ArrayList<Integer>[] arr;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visiting = new int[numCourses];
        arr = new ArrayList[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            if (arr[course] == null) {
                arr[course] = new ArrayList();
            }
            arr[course].add(prereq);
        }
        for (int course = 0; course < numCourses; course++) {
            if (dfs(course) == false) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs (int course) {
        if (visiting[course] == 1) {
            return false;
        }
        if (arr[course] == null) {
            return true;
        }
        visiting[course] = 1;
        for (int prereq : arr[course]) {
            if (dfs(prereq) == false) {
                return false;
            }
        }
        visiting[course] = 0;
        arr[course] = null;
        return true;
    }

    @Test
    public void test() {
        int[][] matrix = new int[2][2];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 2;
        System.out.println(canFinish(3, matrix));

    }
}
