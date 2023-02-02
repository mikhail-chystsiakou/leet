package by.mich;

import java.util.ArrayList;
import java.util.HashSet;

public class L0073_SetMatrixZeroes {
    public static void main(String[] args) {
//        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
//        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
//        setZeroes(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0}});
        setZeroesSet(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
    public static void setZeroes(int[][] matrix) {
        setZeroesRecursive(matrix, 0, 0);
    }

    public static void setZeroesSet(int[][] matrix) {
        HashSet<Integer> zi = new HashSet<>();
        HashSet<Integer> zj = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)  {
                    zi.add(i);
                    zj.add(j);
                }
            }
        }
        for (int i : zi) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : zj) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void setZeroesRecursive(int[][] matrix, int i, int j) {
        int zi = -1, zj = -1;
        outer: for (; i < matrix.length; i++) {
            for (; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)  {
                    zi = i;
                    zj = j;
                    setZeroesRecursive(matrix, i, j+1);
                    break outer;
                }
            }
            j = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int m = 0; m < matrix[k].length; m++) {
                if (k == zi || m == zj) {
                    matrix[k][m] = 0;
                }
            }
        }
    }
}
