package elementary;

import java.util.Stack;

public class IsValid {
    /*
        有效的括号
            给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

            有效字符串需满足：

            左括号必须用相同类型的右括号闭合。
            左括号必须以正确的顺序闭合。
     */

    /*
        栈
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char temp : chars) {
            int value = getValue(temp);
            if (value < 3) {
                stack.add(value);
            } else {
                if (stack.isEmpty() || value - stack.pop() != 3) return false;
            }
        }
        return stack.isEmpty();
    }

    private int getValue(char c) {
        switch (c) {
            case '(':
                return 0;
            case '[':
                return 1;
            case '{':
                return 2;
            case ')':
                return 3;
            case ']':
                return 4;
            case '}':
                return 5;
            default:
                throw new IllegalArgumentException();
        }
    }
}
