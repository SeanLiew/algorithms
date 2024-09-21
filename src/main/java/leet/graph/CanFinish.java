package leet.graph;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        ArrayList<Integer>[] arr = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            arr[prereq].add(course);
            indeg[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            Integer poll = queue.poll();
            ArrayList<Integer> arrayList = arr[poll];
            for (int i : arrayList) {
                --indeg[i];
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return visited == numCourses;
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
        System.out.println(canFinish2(2, matrix));

    }
}
