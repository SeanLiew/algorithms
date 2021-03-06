package leet.strs;

import org.junit.Test;

/**
 * @Description:
 * @author: liuxiaozheng
 * @Created: 2021-03-06-19:38
 */
public class SpaceChange {
    @Test
    public void test(){
        String str = "a d f";
        String result = replaceSpace(str);
        System.out.println(result);

    }

    public String replaceSpace(String str) {
        //%20

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == ' '){
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
