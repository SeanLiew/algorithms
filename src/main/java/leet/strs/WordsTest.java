package leet.strs;

import org.junit.Test;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2020/1/7  20:11
 **/
public class WordsTest {
    @Test
    public void test(){
        String strs = "a  asd   ";
        int result = lengthOfLastWord(strs);
        System.out.println(result);

    }

    public int lengthOfLastWord(String s) {
        int size = s.length();
        int firstIndex = 0;
        for (int i = size - 1; i >= 0; i--){
            char c = s.charAt(i);
            if (c == 32 && i == size - 1){
                size = size - 1;
                continue;
            }
            if (c != 32){
                firstIndex = i;
            }
            if (c == 32){
                break;
            }

        }
        return size - firstIndex;
    }
}
