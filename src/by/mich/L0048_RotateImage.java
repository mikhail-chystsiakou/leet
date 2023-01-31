package by.mich;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image
 * by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify
 * the input 2D matrix directly. DO NOT allocate another 2D matrix
 * and do the rotation.
 */
public class L0048_RotateImage {
    public static void main(String[] args) {
        rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }

    // https://leetcode.com/problems/rotate-image/submissions/889068945/
    // 0ms 41mb
    // 100 53
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i*2 < matrix.length-1; i++) {
            int m = matrix[0].length;
            for (int j = 0; j*2 < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][m - 1 - j];
                matrix[n - 1 - i][m - 1 - j] = matrix[j][m - 1- i];
                matrix[j][m - 1- i] = tmp;
            }
        }
    }
}
