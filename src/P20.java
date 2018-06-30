import java.util.Stack;

/**
 * @author zhaotian
 * @date 2018/6/29 17:31
 */

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//
//        注意空字符串可被认为是有效字符串。
public class P20 {
    public static void main(String[] args) {
        String s = "(([]){})";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        if (length == 0) {
            return true;
        } else if (s.length() % 2 == 0) {
            while (i < length) {
                char cur_char = s.charAt(i);
                if (!stack.empty()) {
                    char top = stack.peek();
                    switch (top) {
                        case '(': {
                            if (cur_char == ')') {
                                stack.pop();
                                break;
                            }
                            if (cur_char=='('||cur_char == '{' || cur_char == '[') {
                                stack.push(cur_char);
                                break;
                            }
                            else {
                                return false;
                            }
                        }
                        case '{': {
                            if (cur_char == '}'){ stack.pop();break;}
                            if (cur_char=='('||cur_char == '{' || cur_char == '[') {stack.push(cur_char);break;}
                            else {
                                return false;
                            }
                        }
                        case '[': {
                            if (cur_char == ']') {
                                stack.pop();
                                break;
                            }
                            if (cur_char=='('||cur_char == '{' || cur_char == '[') {
                                stack.push(cur_char);
                                break;
                            }
                            else {
                                return false;
                            }
                        }
                    }
                } else {
                    stack.push(cur_char);
                }
                i++;
            }
            return stack.isEmpty();
        } else return false;
    }
}
