package com.cyf.LeetCode;

import java.util.HashMap;
import java.util.Stack;


/**
 * @Auther: ChenYF
 * @Date: 2019/10/1 00:58
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 练习次数：1->success
 */

public class 括号匹配 {

    public static boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public boolean isValue1(String s) {
        //用key-value来存储，可快速比较是否是规定的值
        HashMap<Character, Character> mappings = new HashMap<>();
        //以闭为键，开为值
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        //栈来存储比较的字符串
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果为闭则比较是否有匹配的，否则入栈
            if (mappings.containsKey(c)) {

                //先获取栈顶，再比较
                char tmp = stack.isEmpty() ? '!' : stack.pop();
                if (tmp != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        /*mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');*/

        String s = "[((({(})))]";
        String l = "";
        System.out.println(isValid(s));
    }

    public static boolean isValid1(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char k = stack.isEmpty() ? '!' : stack.pop();
                if (k != map.get(c)) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}

