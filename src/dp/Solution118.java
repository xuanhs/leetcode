package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/8/2 21:37
 * @description： 杨辉三角
 */
public class Solution118 {

    /**
     *暴力了，想不到更好的解法
     * 可能有更节省空间的方法，但是时间上应该比较难了
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows * 2);
        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                    continue;
                }
                int k = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                rows.add(k);
            }
            res.add(rows);
        }
        return res;
    }
}
