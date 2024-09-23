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

    int[] visited;
    ArrayList<Integer>[] arr;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        arr = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            arr[prereq].add(course);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] ==0) {
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs (int course) {
        visited[course] = 1;
        for (int nextCourse : arr[course]) {
            if (visited[nextCourse] == 0) {
                dfs(nextCourse);
                if (!valid) {
                    return;
                }
            } else if (visited[nextCourse] == 1){
                valid = false;
                return;
            }
        }
        visited[course] = 2;
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
        System.out.println(canFinish(2, matrix));

    }
}
