package elementary;

public class ClimbStairs {
    /*
        爬楼梯
            假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

            每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

            示例 1：

                输入： 2
                输出： 2
                解释： 有两种方法可以爬到楼顶。
                1.  1 阶 + 1 阶
                2.  2 阶

            示例 2：

                输入： 3
                输出： 3
                解释： 有三种方法可以爬到楼顶。
                1.  1 阶 + 1 阶 + 1 阶
                2.  1 阶 + 2 阶
                3.  2 阶 + 1 阶
     */

    /*
        递归
     */
    public static int[] data = new int[50];

    static {
        data[1] = 1;
        data[2] = 2;
    }

    public int climbStairs(int n) {
        if (n < data.length && data[n] != 0) return data[n];
        data[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return data[n];
    }

    /*
        暴力解法
     */
    public int climbStairs1(int n) {
        int[] ints = new int[n + 2];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    /*
        暴力解法
            优化内存空间
     */
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int last = 1,
                next = 2;
        for (int i = 3; i < n; i++) {
            int temp = last;
            last = next;
            next = temp + last;
        }
        return last + next;
    }

    /*
        数学公式计算
            斐波那契公式
     */
    public static int climbStairs3(int n) {
        double sqrt = Math.sqrt(5); // 根号5
        return (int) ((Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1)) / sqrt);
    }

}
