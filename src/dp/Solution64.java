package dp;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
public class Solution64 {

    /**
     * 与62一模一样的思路，只不过62每一步是加1，这道题每一步是加本身的数值
     * easy to do
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    nums[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    nums[i][j] = nums[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    nums[i][j] = nums[i - 1][j] + grid[i][j];
                    continue;
                }
                nums[i][j] = Math.min(nums[i][j - 1], nums[i - 1][j]) + grid[i][j];
            }
        }
        return nums[n - 1][m - 1];
    }
}
