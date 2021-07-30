package com.mrxu;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/14 17:48
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int times = (matrix.length + 1) >> 1;
        for (int i = 0; i < times; i++) {
            int l = (matrix.length - (i << 1)) - 1;
            for (int k = 0; k < l; k++) {
                int temp = matrix[i][i + k];
                matrix[i][i + k] = matrix[l + i - k][i];
                matrix[l + i - k][i] = matrix[l + i][l + i - k];
                matrix[l + i][l + i - k] = matrix[i + k][l + i];
                matrix[i + k][l + i] = temp;
            }
        }
    }
}
