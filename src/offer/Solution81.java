package offer;

import java.util.ArrayList;
import java.util.List;

//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
//
//
//
// 示例 1：
//
//
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
//
//
// 示例 2：
//
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
//输入: candidates = [2], target = 1
//输出: []
//
//
// 示例 4：
//
//
//输入: candidates = [1], target = 1
//输出: [[1]]
//
//
// 示例 5：
//
//
//输入: candidates = [1], target = 2
//输出: [[1,1]]
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
//
//
//
// 注意：本题与主站 39 题相同： https://leetcode-cn.com/problems/combination-sum/
// Related Topics 数组 回溯
// 👍 2 👎 0
public class Solution81 {


    /**
     * 回溯的思想，不断优化选择
     * 本题有两种选择：
     *     1. 跳过当前位置，选择下一个位置的元素；此时不需要回头
     *     2. 选择当前位置，继续试错，试错完放弃此次选择
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> con = new ArrayList<>();
        dfs(res, con, candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> con, int[] candidates, int target, int i) {
        if (i == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(con));
            return;
        }
        dfs(res, con, candidates, target, i + 1);
        if (target - candidates[i] >= 0) {
            con.add(candidates[i]);
            dfs(res, con, candidates, target - candidates[i], i);
            con.remove(con.size() - 1);
        }
    }
}
