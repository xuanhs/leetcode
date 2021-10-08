package offer;

//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
//
//输入: a = "11", b = "10"
//输出: "101"
//
// 示例 2:
//
//
//输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
//
//
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
// Related Topics 位运算 数学 字符串 模拟
// 👍 5 👎 0
public class Solution2 {

    /**
     * 模拟加法
     * 短字符串补0
     */
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int maxLen = Math.max(lena, lenb);
        for (int i = lena; i < maxLen; i++) {
            a = "0" + a;
        }
        for (int i = lenb; i < maxLen; i++) {
            b = "0" + b;
        }
        int temp = 0;
        String res = "";
        for (int i = maxLen - 1; i >= 0; i--) {
            int ai = a.charAt(i) - '0';
            int bi = b.charAt(i) - '0';
            int resi = (ai + bi + temp) % 2;
            temp = (ai + bi + temp) / 2;
            res = String.valueOf(resi) + res;
        }
        if (temp >= 1) {
            res = "1" + res;
        }
        return res;
    }

}
