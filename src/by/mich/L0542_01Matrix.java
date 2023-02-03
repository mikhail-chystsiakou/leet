package by.mich;

/**
 * Given an m x n binary matrix mat,
 * return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1
 */
public class L0542_01Matrix {
    public static void main(String[] args) {
        updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }

    // https://leetcode.com/problems/01-matrix/submissions/890678669/
    // 94 60
    public static int[][] updateMatrix(int[][] mat) {

        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = mat.length + mat[0].length;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    if (i > 0) res[i][j] = Math.min(res[i][j], res[i-1][j]+1);
                    if (j > 0) res[i][j] = Math.min(res[i][j], res[i][j-1]+1);
                }
            }
        }

        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0 ; j--) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    if (i < mat.length - 1) res[i][j] = Math.min(res[i][j], res[i+1][j]+1);
                    if (j < mat[0].length - 1) res[i][j] = Math.min(res[i][j], res[i][j+1]+1);
                }
            }
        }

        return res;
    }

    // https://leetcode.com/problems/01-matrix/submissions/890672745/
    public static int[][] updateMatrixTimeLimitExceed(int[][] mat) {

        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = mat.length + mat[0].length;
            }
        }
        int[] zi = new int[mat.length * mat[0].length];
        int[] zj = new int[mat.length * mat[0].length];
        int zc = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    zi[zc] = i;
                    zj[zc] = j;
                    zc++;
                }
            }
        }
        int m = Math.max(mat.length, mat[0].length);
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < zc; ++i) {
                fillDistance(res, zi[i], zj[i], j);
            }
        }

        return res;
    }

    public static void fillDistance(int[][] res, int i, int j, int lvl) {
        for (int ii = 0; ii <= lvl; ii++) {
            int jj = lvl - ii;
            int i1 = i + ii;
            int i2 = i - ii;
            int j1 = j + jj;
            int j2 = j - jj;

            int il = res.length;
            int jl = res[0].length;

            if (i1 < il && j1 < jl && res[i1][j1] > lvl) res[i1][j1] = lvl;
            if (i2 >= 0 && j1 < jl && res[i2][j1] > lvl) res[i2][j1] = lvl;
            if (i1 < il && j2 >= 0 && res[i1][j2] > lvl) res[i1][j2] = lvl;
            if (i2 >= 0 && j2 >= 0 && res[i2][j2] > lvl) res[i2][j2] = lvl;
        }
    }

    // https://leetcode.com/problems/01-matrix/submissions/890660367/
    // 5 62
    public int[][] updateMatrixBad(int[][] mat) {

        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = mat.length + mat[0].length;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    fillZero(result, i, j);
                }
            }
        }

        return result;
    }

    public void fillZero(int[][] res, int i, int j) {
        for (int ii = 0; ii < res.length; ii++) {
            for (int jj = 0; jj < res[0].length; jj++) {
                int curDis = res[ii][jj];
                int newDis = Math.abs(i - ii) + Math.abs(j -jj);
                if (newDis < curDis) {
                    res[ii][jj] = newDis;
                }
            }
        }
    }
}
