package elementary;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    /*
        杨辉三角
            给定一个非负整数numRows，生成杨辉三角的前numRows行。



            在杨辉三角中，每个数是它左上方和右上方的数的和。

            示例:

                输入: 5
                输出:
                [
                     [1],
                    [1,1],
                   [1,2,1],
                  [1,3,3,1],
                 [1,4,6,4,1]
                ]
     */

    /*
        暴力解法
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>(i + 1));
            List<Integer> curr = list.get(i),
                    last = i > 0 ? list.get(i - 1) : null;
            for (int j = 0; j < i + 1; j++) {
                if (last == null) {
                    curr.add(1);
                    break;
                }
                int left = j - 1 >= 0 ? last.get(j - 1) : 0,
                        right = j < last.size() ? last.get(j) : 0;
                curr.add(left + right);
            }
        }
        return list;
    }
}
