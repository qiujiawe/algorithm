package elementary;

public class IsPowerOfThree {
    /*
        3的幂
            给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

            整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     */

    /*
        暴力解法
     */
    public boolean isPowerOfThree(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }

    /*
        递归
     */
    public boolean isPowerOfThree1Helper(int n) {
        if (n % 3 != 0) return n == 1;
        return isPowerOfThree1(n / 3);
    }

    public boolean isPowerOfThree1(int n) {
        if (n == 0) return false;
        return isPowerOfThree1Helper(n);
    }

    /*
        算术表达式计算
     */
    public boolean isPowerOfThree2(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /*
        int类型3的最大幂是1162261467,我们直接用它对n求余即可，过求余的结果是0，说明n是3的幂次方
     */
    public boolean isPowerOfThree3(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }


}
