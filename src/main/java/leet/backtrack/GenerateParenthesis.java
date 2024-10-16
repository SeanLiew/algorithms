package leet.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-16 15:53
 */
public class GenerateParenthesis {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack (int n, int leftCount, int rightCount, StringBuilder stringBuilder) {
        if (leftCount == n && rightCount == n) {
            result.add(stringBuilder.toString());
            return;
        }
        if (rightCount > leftCount) {
            return;
        }
        if (leftCount < n) {
            stringBuilder.append('(');
            backtrack(n, leftCount + 1, rightCount, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightCount < leftCount) {
            stringBuilder.append(')');
            backtrack(n, leftCount, rightCount + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generateParenthesis(3)));
    }
}
