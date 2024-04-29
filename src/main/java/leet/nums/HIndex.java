package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int h = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < h) {
                h--;
            }
        }
        return h;
    }

    @Test
    public void test(){
        System.out.println(hIndex(new int []  {0,3,3,3}));
    }
}
