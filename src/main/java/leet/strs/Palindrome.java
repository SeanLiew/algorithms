package leet.strs;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2021/3/4  11:10
 **/
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("abac"));
        System.out.println(longestPalindrome("adbdac"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("cbba"));
    }


    public static String longestPalindrome(String s) {
        if (s == null){
            return null;
        }

        String maxSub = s.substring(0 ,1);

        for (int i = 0; i < s.length(); i++){
            String substring = s.substring(i);
            String s1 = subMaxPalindrome(substring);
            if (s1.length() > maxSub.length()){
                maxSub = s1;
            }
        }
        return maxSub;
    }

    /**
     * 子串的最大回文串
     * @param s
     * @return
     */
    public static String subMaxPalindrome(String s) {
        i : for (int i = s.length() - 1; i >= 0; i--){
            int lastIndex = i;
            for (int j = 0; j <= i; j++){
                if (lastIndex <= j){
                    return s.substring(0, i + 1);
                }
                if (s.charAt(j) != s.charAt(lastIndex)){
                    continue i;
                }
                lastIndex--;
            }
        }
        return null;
    }




}
