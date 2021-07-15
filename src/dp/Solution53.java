package dp;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/15 22:08
 * @description： 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 开始想要用数组记录状态，找出最大状态即可。
 * 推导状态变更公式时，发现只有前驱节点会影响后驱结果，于是不需要记录状态，详细如下：
 * 使用两个状态，max记录总体最大的子序列和，sum记录当前子序列和 max = Max(max,sum);
 * 而sum很明显，只要当前节点nums[i] > 已有节点和，或者是 sum < 0，则直接取nums[i]作为sum，相当于刷新了sum的起始位置。
 * 否则sum += nums[i]即可.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //此处可以优化为 sum<0
            if (nums[i] > sum && sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
