package leet.nums;

import leet.tree.TreeNode;
import org.junit.Test;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || t.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < s.length() && index2 < t.length()) {
            char sc = s.charAt(index1);
            char st = t.charAt(index2);
            if (sc == st) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return index1 == s.length();
    }
    @Test
    public void test(){
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("abc", "abbcd"));
        System.out.println(isSubsequence("abc", "qabcd"));
        System.out.println(isSubsequence("axc", "qabcd"));

    }
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
    @Test
    public void test2(){
        System.out.println(isSubsequence2("abc", "ahbgdc"));
        System.out.println(isSubsequence2("abc", "abbcd"));
        System.out.println(isSubsequence2("abc", "qabcd"));
        System.out.println(isSubsequence2("axc", "qabcd"));

    }
}
