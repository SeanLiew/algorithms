package leet.strs;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-13 19:46
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < s.length(); right++ ) {
            char c = chars[right];
            while (set.contains(c)) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("aa"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("abbcf"));
        System.out.println(lengthOfLongestSubstring("abccfhhjkl"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    @Test
    public void test2(){
        String s = "dvdf";
        char c = s.charAt(1);
        System.out.println("dvdf".indexOf(c));
    }
}
