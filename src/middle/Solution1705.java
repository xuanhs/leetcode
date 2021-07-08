package middle;

import java.util.PriorityQueue;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/8 19:34
 * @description： apples[i]为i点的数量， days[i]为i点苹果存活时间（i+days[i]时过期）
 * 一开始想着直接贪心解决了，不太好写出来前一个比后一个晚过期的场景
 * 转换成优先队列，但索然无味，稍微看了题解复制了一份
 */
public class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        // 优先队列，队首是最早过期的  int[0]:苹果个数  int[1]:过期时间
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        int eatNum = 0;
        for (int i = 0; i < apples.length || queue.size() > 0; i++) {
            while (!queue.isEmpty()) {
                int[] apple = queue.peek();
                if (apple[1] <= i) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (i < apples.length && apples[i] > 0) {
                queue.add(new int[]{apples[i], days[i] + i});
            }
            int[] ap = queue.peek();
            if (ap != null && ap[0] > 0) {
                eatNum++;
                ap[0]--;
                if (ap[0] == 0) {
                    queue.poll();
                }
            }
        }
        return eatNum;
    }
}
