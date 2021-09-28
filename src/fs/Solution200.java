package fs;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 1348 👎 0
public class Solution200 {

    int[] xx = new int[]{1, -1, 0, 0};
    int[] yy = new int[]{0, 0, 1, -1};

    /**
     * 解题思路比较简单，发现新岛屿加一
     * 并且将可以到达的陆地归为新发现的岛屿，主要是bfs
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        int n = grid.length;
        int m = grid[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] tags = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && tags[i][j] != 1) {
                    num++;
                    bfsTag(grid, tags, i, j);
                }
            }
        }
        return num;
    }

    private void bfsTag(char[][] grid, int[][] tags, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        tags[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int n = x + xx[i];
            int m = y + yy[i];
            if (n < 0 || m < 0 || n >= grid.length || m >= grid[0].length) {
                continue;
            }
            if (grid[n][m] == '1' && tags[n][m] != 1) {
                tags[n][m] = 1;
                bfsTag(grid, tags, n, m);
            }
        }
    }
}
