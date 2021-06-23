package middle;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/6/23 22:49
 * @description： 水果成蓝
 * 主要思路：
 * 类似窗口的做法
 * 记录最多两个不一样的水果，当出现第三个水果时，进行顺序替换，例如已有水果a,b，出现第三个水果c，则a=b,b=c
 * 需要注意的是，当统计长度时，我们用的是新出现的水果位置-a水果第一次出现的位置
 * 那么我们需要一个标识位记录：当第三个水果出现时，b水果第一次出现的位置
 */
public class Solution904 {
    public int totalFruit(int[] tree) {
        int len = 0;
        int a = 0, b = 0;
        int temp = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != tree[a] && tree[i] != tree[b]) {
                if (a != b) {
                    a = temp;
                }
                b = i;
            }
            len = Math.max(len, i - a + 1);
            if (tree[temp] != tree[i]) {
                temp = i;
            }
        }
        return len;
    }
}
