package com.mrxu;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jlxu@telenav.cn
 * @date 2021/8/11/16:50
 */
public class KuoHaoBiHe {
    private static List<Character> s1 = Arrays.asList('(', '[', '{');
    private static List<Character> s2 = Arrays.asList(')', ']', '}');

    public static void main(String[] args) {
        String s = "asdf[sadf{(asdf)}daf]";
        System.out.println(check(s));
    }

    private static boolean check(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (s1.contains(chars[i])) {
                stack.push(chars[i]);
            } else if (s2.contains(chars[i])) {
                Character temp = stack.pop();
                if (temp == '(' && ')' != chars[i] || temp == '[' && ']' != chars[i] || temp == '{' && '}' != chars[i]) {
                    return false;
                }
            }
        }
        return true;
    }

}
