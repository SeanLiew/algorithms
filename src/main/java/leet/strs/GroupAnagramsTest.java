package leet.strs;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-21 22:09
 */
public class GroupAnagramsTest {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map.put(s, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
    @Test
    public void test(){
        String[] strs = new String[] {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(JSON.toJSONString(lists));

    }
    @Test
    public void test2(){
        char[] chars = "eat".toCharArray();
        String s = String.valueOf(chars);
        System.out.println(s);

    }
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int p = arr1.length - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            while (m >= 0 && (n < 0 || arr1[m] > arr2[n])) {
                arr1[p--] = arr1[m--];
            }
            while (n >= 0 && (m < 0 || arr1[m] <= arr2[n])) {
                arr1[p--] = arr2[n--];
            }
        }
    }
    @Test
    public void test3(){
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        merge(arr1, 3, arr2, 3);
        System.out.println(JSON.toJSONString(arr1));

    }
}
