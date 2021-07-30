package com.mrxu;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/15 16:22
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2,4,4,5};
        int[] array2 = {1};
        findMedianSortedArrays(array1, array2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int m = len / 2;
        int n = m;
        if (len % 2 == 0) {
            n = m + 1;
        }
        int i = 0, j = 0;
        for (; i + j < m; ) {
            if (nums1[i] >= nums2[j]) {
                if (j == nums2.length - 1)
                    i++;
                else
                    j++;
            } else {
                if (i == nums1.length - 1)
                    j++;
                else
                    i++;
            }
        }
        return m != n ? 0:0;
    }
}
