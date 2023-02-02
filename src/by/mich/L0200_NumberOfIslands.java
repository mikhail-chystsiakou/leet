package by.mich;

/**
 * Given an m x n 2D binary grid which represents
 * a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent
 * lands horizontally or vertically. You may assume all four edges
 * of the grid are all surrounded by water.
 */
public class L0200_NumberOfIslands {
    public static void main(String[] args) {
        numIslands(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}});
    }

    // https://leetcode.com/problems/number-of-islands/submissions/890333788/
    // 90 84
    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    nullifyIsland(grid, i, j, i, j);
                }
            }
        }
        return islands;
    }

    // 1 1 1
    // 0 1 0
    // 1 1 1
    public static void nullifyIsland(char[][] grid, int i, int j, int ip, int jp) {
        if (i < 0 || j < 0 ) return;
        if (i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';
        if (i+1 != ip) nullifyIsland(grid, i+1, j, i, j);
        if (i-1 != ip) nullifyIsland(grid, i-1, j, i, j);
        if (j+1 != jp) nullifyIsland(grid, i, j+1, i, j);
        if (j-1 != jp) nullifyIsland(grid, i, j-1, i, j);
    }
}
