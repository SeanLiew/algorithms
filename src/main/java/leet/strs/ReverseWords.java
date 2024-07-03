package leet.strs;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-06-27 20:08
 */
public class ReverseWords {
    public String reverseWords(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int end = length;
        int start = length - 1;
        while (start >= 0) {
            char c = s.charAt(start);
            if (c == ' ' || start == 0) {
                if (c == ' ' && start == end -1) {
                    end = start;
                    start--;
                    continue;
                }
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                if (start != 0 || c == ' ') {
                    sb.append(s.substring(start+1, end));
                } else {
                    sb.append(s.substring(start, end));
                }
                end = start;
                start--;
                continue;
            }
            start--;
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(reverseWords(" d df"));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("EPY2giL"));
        System.out.println(reverseWords("a go"));
        System.out.println(reverseWords("  hello world  "));
    }

    public String reverseWords2(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int end = length;
        int start = length - 1;
        boolean last = true;
        while (start >= 0) {
            while (end > 0 && s.charAt(end-1) == ' ') {
                end--;
            }
            while (end > 0 && start >= end) {
                start--;
            }
            if (start == 0 && start != end) {
                if (!last) {
                    sb.insert(0, ' ');
                } else {
                    last = false;
                }
                if (s.charAt(start) == ' ') {
                    sb.insert(0, s.substring(start + 1, end));
                } else {
                    sb.insert(0, s.substring(start, end));
                }
                start--;
                continue;
            }
            if (end > 0 && s.charAt(start) == ' ') {
                if (!last) {
                    sb.insert(0, ' ');
                } else {
                    last = false;
                }
                sb.insert(0, s.substring(start + 1, end));
                end = start;
                start--;
                continue;
            }
            start--;
        }
        return sb.toString();
    }

    @Test
    public void test2(){
        System.out.println(reverseWords2("  ho wd  "));

        System.out.println(reverseWords2("a go"));
        System.out.println(reverseWords2("EPY2giL"));
//
        System.out.println(reverseWords2(" d df"));
        System.out.println(reverseWords2("the sky is blue"));
    }
}
