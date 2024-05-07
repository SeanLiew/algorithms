package leet.nums;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String firstStr = strs[0];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1) {
                    return stringBuilder.toString();
                }
                char subC = strs[j].charAt(i);
                if (c != subC) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
        }
        return firstStr;
    }

    @Test
    public void test(){
        String[] arr = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(arr));
    }
}
