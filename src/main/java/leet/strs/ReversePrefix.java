package leet.strs;

import org.junit.Test;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-08-22 23:55
 */
public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = word.length() - 1; i >=0; i--) {
            char c = word.charAt(i);
            if (c == ch) {
                index = i;
            }
        }
        if (index > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ch);
            for (int i = index - 1; i >= 0; i--) {
                stringBuilder.append(word.charAt(i));
            }
            if (index < word.length() - 1) {
                stringBuilder.append(word.substring(index + 1, word.length()));
            }
            return stringBuilder.toString();
        }

        return word;
    }

    @Test
    public void test() {
        System.out.println(reversePrefix("abcdefd", 'd'));

    }
}
