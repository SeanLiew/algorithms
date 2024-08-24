package leet.stacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        path.split("/");
        for (String str : path.split("/")) {
            if (".".equals(str) || "".equals(str)) {
                continue;
            }
            if (stack.isEmpty()) {
                if ("..".equals(str)) {
                    continue;
                }
                stack.push(str);
            } else {
                if ("..".equals(str)) {
                    stack.pop();
                    continue;
                }
                stack.push(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            stringBuilder.insert(0, pop);
            if (!stack.isEmpty()) {
                stringBuilder.insert(0, "/");
            }
        }
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) != '/') {
            stringBuilder.insert(0, "/");
        }
        return stringBuilder.toString();
    }

    @Test
    public void testIsValid(){
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home/../../.."));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/aaa/"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));

    }
}
