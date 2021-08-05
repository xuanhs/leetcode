package dp;

//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
// 示例 1:
//
//
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//
//
// 示例 2:
//
//
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//
//
// 示例 3:
//
//
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 3 * 104
// 0 <= prices[i] <= 104
//
// Related Topics 贪心 数组 动态规划
// 👍 1296 👎 0
public class Solution122 {

    /**
     * 想法比较简单，首先需要明确，要想获取最大的利益，必然在最低点有一次买入，最高点有一次卖出
     * 由于题目是可以多次买入卖出，很容易推算出来，需要在每次最低点和每次最高点买入卖出
     * 那么使用一个标识位keep，表示是否已经买入
     * 在没有买入时，寻找最低位置买入（降序子序列）
     * 在买入时，寻找最高位置买入（升序子序列）
     * 代码写得有点丑陋，明天看看别人是怎么写的
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int min = prices[0];
        boolean keep = prices.length > 1 && prices[1] > prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (!keep && prices[i] < prices[i - 1]) {
                min = prices[i];
                continue;
            }
            if (keep && prices[i] >= prices[i - 1] && i < prices.length - 1) {
                continue;
            }
            if (prices[i] <= prices[i - 1]) {
                sum += prices[i - 1] - min;
                min = prices[i];
            }
            if (i == prices.length - 1 && prices[i] > prices[i - 1]) {
                sum += prices[i] - min;
            }
            keep = !keep;
        }
        return sum;
    }
}
