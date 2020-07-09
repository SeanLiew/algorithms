package leet.nums;

import org.junit.Test;

/**
 * desc: excel列表名称
 * author: liuxiaozheng
 * time: 2020/7/8  17:30
 **/
public class Excel {
    @Test
    public void test(){
        String str = convertToTitle(27);
        System.out.println(str);
    }

    public String convertToTitle(int n) {
        StringBuffer sBuilder = new StringBuffer();
        //65-90 97-122 48-57
        while (true){
            int m;
            char str;
            if (n > 26){
                n--;
                m = n % 26;
                n = n / 26;
                str = (char)(65 + m);
                sBuilder.insert(0, str);
            } else {
                str = (char)(65 + n - 1);
                sBuilder.insert(0, str);
                return sBuilder.toString();

            }
        }
    }
}
