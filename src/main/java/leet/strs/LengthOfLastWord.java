package leet.strs;

import org.junit.Test;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        boolean firstBlank = true;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (firstBlank) {
                    continue;
                }
                return num;
            } else {
                firstBlank = false;
                num++;
            }
        }
        return num;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLastWord("c "));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("cc"));
        System.out.println(lengthOfLastWord("ab bcc"));
        System.out.println(lengthOfLastWord("r rs"));

    }
}
