package leet.excels;

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
    @Test
    public void test2(){
        int num = convertToNum("ABA");
        System.out.println(num);
    }

    public int convertToNum(String str) {
        //65-90 97-122 48-57
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--){
            char c = str.charAt(i);
            int cnum = c - 65 + 1;
            if (i == str.length() - 1){
                result = result + cnum ;
            } else {
                int in = cnum * (int)Math.pow(26, str.length() -1 - i);
                System.out.println(in);
                result = result + in;
            }
        }
        return result;
    }
}
