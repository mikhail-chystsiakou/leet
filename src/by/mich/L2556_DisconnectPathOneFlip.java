package by.mich;

/**
 * You are given a 0-indexed m x n binary matrix grid.
 * You can move from a cell (row, col) to any of the cells
 * (row + 1, col) or (row, col + 1) that has the value 1.
 * The matrix is disconnected if there is no path from (0, 0) to (m - 1, n - 1).
 *
 * You can flip the value of at most one (possibly none) cell.
 * You cannot flip the cells (0, 0) and (m - 1, n - 1).
 *
 * Return true if it is possible to make the matrix disconnect or false otherwise.
 *
 * Note that flipping a cell changes its value from 0 to 1 or from 1 to 0.
 */
public class L2556_DisconnectPathOneFlip {
    // https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/submissions/891484040/
    // 100 100
    public boolean isPossibleToCutPath(int[][] grid) {
        getPathRecursive(grid, 0, 0);
        grid[0][0] = 1;
        return !getPathRecursive(grid, 0, 0);
    }

    public boolean getPathRecursive(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[i].length || grid[i][j] == 0) return false;
        if (i == grid.length - 1 && j == grid[i].length - 1) return true;

        grid[i][j] = 0;

        return getPathRecursive(grid, i+1, j) || getPathRecursive(grid, i, j+1);
    }
}
