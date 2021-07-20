package dp;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/19 16:47
 * @description： 最长回文子串
 */
public class Solution5 {

    /**
     * 暴力
     * 暴力没啥好说的，题目看到只有1000的长度，这不是诱惑我自己暴力嘛
     * 不过暴力的时候也出了点问题，后续的代码应该可以合并分支和剪枝
     *
     * @param s 入参
     * @return 最长回文子串
     */
    public String longestPalindrome1(String s) {
        String res = s.substring(0, 1);
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int max1 = 1;
            int max2 = 0;
            int j1 = i, j2 = i + 1, h = i - 1, k = i + 1;
            while (h >= 0 && k < s.length() && s.charAt(h) == s.charAt(k)) {
                max1 += 2;
                h--;
                k++;
            }
            while (j1 >= 0 && j2 < s.length() && s.charAt(j1) == s.charAt(j2)) {
                if (s.charAt(j1) == s.charAt(j2)) {
                    max2 += 2;
                    j1--;
                    j2++;
                }
            }
            if (max1 > max) {
                max = max1;
                res = s.substring(h + 1, k);
            }
            if (max2 > max) {
                max = max2;
                res = s.substring(j1 + 1, j2);
            }
        }
        return res;
    }

    /**
     * 动态规划解决
     * 不知道是不是dp想得有问题，耗时和内存消耗都增加了
     * 耗时从36ms到了211ms
     * 内存消耗从39m到49m
     * 这个解法就费时费力，不讨好
     *
     * @param s 入参
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int[][] dp = new int[len][len];
        int max = 0;
        int maxl = 0;
        int maxr = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1] == 1)) {
                    dp[j][i] = 1;
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        maxl = j;
                        maxr = i;
                    }
                }
            }
        }
        return s.substring(maxl, maxr + 1);
    }
}
