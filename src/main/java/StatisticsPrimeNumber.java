import java.util.Date;

public class StatisticsPrimeNumber {
    /*
    统计素数个数

    例子:

    输入 100 (计算 0 ~ 100中的素数个数)(素数就是只能被 1 和 自身 整除的数字)
    返回 25

    思路1:
        逐个检查数字是否为素数

        优化:
            判断一个数字 X 是否为素数时没必要从 X % 2 遍历到 X % （X - 1）
            只需要从 2 遍历到 X 的平方根
            及循环条件为 i <= X 的平方根
            写成代码为 i * i <= X 或者 i <= Math.sqrt(number)

    思路2:
        埃筛法，通过排除掉不符合条件的数字来减少循环的次数
        比如:
            2 的倍数 4 6 8 10……(直到 > X)
            3 的倍数 9 15 21 27 ……(直到 > X)
            5 的倍数 25 35 45 55 ……(直到 > X)
            7 的倍数 49 63 77 91 ……(直到 > X)

     */
    public static void main(String[] args) {
        long b = new Date().getTime();
        int count = statisticsPrimeNumberTwo(100000);
        long s = new Date().getTime();
        System.out.println(s - b);
        System.out.println(count);
    }
    // 思路1的实现
    public static int statisticsPrimeNumber(int number) {
        if (number < 2) return 0;
        int count = 1;
        for (int i = 3; i < number; i++) {
            count += isPrimeNumberOptimize(i) ? 1 : 0;
        }
        return count;
    }
    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    // 思路1的实现的优化
    public static boolean isPrimeNumberOptimize(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    // 思路2的实现
    public static int statisticsPrimeNumberTwo(int number) {
        if (number < 2) return 0;
        boolean[] tag = new boolean[number];// false 表示素数(0,1不用管)
        int count = 0;
        for (int i = 2; i < number; i++) {
            // 可以大胆的把没被标记成true的当成素数，因为一开的2，3是素数，且后面不是素数的肯定会被筛掉
            if (!tag[i]) {
                count++;
                // 遍历出 i 的倍数
                for (int j = i; j * i < number && j * i > 0; j += 2) {
                    // 标记为 非素数
                    tag[j * i] = true;
                    // 除了i等于2的时候 需要遍历 2，3，4，5……，其他情况只要遍历大于等于自身的奇数就行了
                    // 比如: 3 只需要遍历 3，5，7，9……
                    //      5 只需要遍历 5，7，9，11……
                    if (i == 2) {
                        j--;
                    }
                }
            }

        }
        return count;
    }
}
