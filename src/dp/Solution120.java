package dp;

import java.util.List;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
// 示例 1：
//
//
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
// 示例 2：
//
//
//输入：triangle = [[-10]]
//输出：-10
//
//
//
//
// 提示：
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104
//
//
//
//
// 进阶：
//
//
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
//
// Related Topics 数组 动态规划
public class Solution120 {

    /**
     * 记忆化搜索 + 动态规划
     * 其实就是从后往前推，每个节点只能由res[i - 1][j], res[i - 1][j - 1]获取，那么只需要找到这两个之中最小的就可以了
     * 怎么样找到呢？
     * 有一个很容易想到的方法是，自顶而下，将每一个节点的最小值记录
     * 因为每个节点直接往下的其实也只是两个而言
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] res = new int[triangle.size()][triangle.size()];
        res[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                if (j == 0) {
                    res[i][j] = res[i - 1][j] + temp.get(j);
                    continue;
                }
                res[i][j] = Math.min(res[i - 1][j], res[i - 1][j - 1]) + temp.get(j);
            }
            res[i][i] = res[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = res[triangle.size() - 1][0];
        for (int i = 1; i < triangle.size(); i++) {
            min = Math.min(min, res[triangle.size() - 1][i]);
        }
        return min;
    }

}
