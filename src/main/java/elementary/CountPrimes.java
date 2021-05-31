package elementary;

public class CountPrimes {
    /*
        计数质数
            统计所有小于非负整数 n 的质数的数量

        示例 1：

            输入：n = 10
            输出：4
            解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7

        示例 2：

            输入：n = 0
            输出：0

        示例 3：

            输入：n = 1
            输出：0
     */

    /*
        埃筛法
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        // flag[2] = false 表示 2 是质数 flag[3] = true 表示 3 不是质数
        boolean[] flag = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (!flag[i]) {
                for (int j = i * i; j < n; j += i * 2) {
                    if (!flag[j]) {
                        flag[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }

}
