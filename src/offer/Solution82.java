package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
//
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/
// Related Topics 数组 回溯
// 👍 3 👎 0
public class Solution82 {

    /**
     * 排序，将同一位置的相同元素去除即可
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, n, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int[] candidate, int n, int idx, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (candidate[i] > target) { // 剪枝
                break;
            }
            if (i > idx && candidate[i] == candidate[i - 1]) { // 剪枝、避免重复
                // 因为前面那个同样的数已经经历过dfs，再拿同样的数dfs就会得到重复的答案(同一位置)
                continue;
            }
            list.add(candidate[i]);
            dfs(candidate, n, i + 1, target - candidate[i], list, ans);
            list.remove(list.size() - 1);
        }
    }
}
