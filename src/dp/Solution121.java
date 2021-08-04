package dp;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/8/2 21:40
 * @description：买卖股票的最佳时机
 */
public class Solution121 {

    //暴力TLE了，就离谱，才105就tle
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    //和暴力差不多，过了，nums[i]记录 >= i的最大值
    //第二次for循环则直接比较prices[i] 和 nums[i]即可
    public int maxProfit2(int[] prices) {
        int[] nums = new int[prices.length];
        int max = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            nums[i] = max;
        }
        max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (nums[i] - prices[i] > max) {
                max = nums[i] - prices[i];
            }
        }
        return max;
    }

    /**
     * 相比于2，是把记录的最大值去掉了
     * 转换了思路，改成记录最小值，每次与当前位置比较即可
     * 但其实思路是一致的，只不过只记录了一个最小值，而不是把所有位置的最小值记录下来
     */
    public int maxProfit3(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
