package dp;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/29 21:38
 * @description： 爬楼梯
 */
public class Solution70 {

    /**
     * 学习的时候写过类似的题目...就直接写了斐波那契
     * 至于为什么，思考一下：
     * 每次可以走一步或者两步，也就是每次会有两种选择
     * 那么假设目的地是n，对于达到n，我们可以由n-1走一步到达，也可以由n-2走两步到达
     * 也就说，走到n的方式是走到n-1 和 走到n-2的方式的和
     * 重复以上步骤，即可
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
