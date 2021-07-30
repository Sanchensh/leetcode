package com.mrxu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/14 14:03
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123454321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int j = 0;
        int point = x;
        do {
            j = point % 10 + j * 10;
        } while ((point = point / 10) > 0);
        return j == x;
    }
}
