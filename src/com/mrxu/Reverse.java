package com.mrxu;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/14 14:03
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        long j = 0;
        long point = x;
        if (point < 0) {
            point = point * -1L;
        }
        do {
            j = point % 10L + j * 10L;
            if (j > Integer.MAX_VALUE)
                return 0;
        } while ((point = point / 10) > 0);
        return (int) (x < 0 ? -j : j);
    }
}
