package elementary;

public class HammingWeight {
    /*
        位1的个数
            编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

        提示：

        请注意，在某些语言（如 Java）中，没有无符号整数类型。
        在这种情况下，输入和输出都将被指定为有符号整数类型，
        并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3

        示例 1：

            输入：00000000000000000000000000001011
            输出：3
            解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'

        示例 2：

            输入：00000000000000000000000010000000
            输出：1
            解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'

        示例 3：

            输入：11111111111111111111111111111101
            输出：31
            解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'
     */

    /*
        暴力解法
     */
    public int hammingWeight(int n) {
        long temp = n;
        // true 表示负数
        boolean flag = false;
        // 如果是负数则转成正数
        if (temp < 0) {
            flag = true;
            temp *= -1;
        }
        // false 表示 0 ,true 表示 1
        boolean[] bit = new boolean[32];
        // 把正数转成二进制原码
        for (int i = bit.length - 1; i >= 0; i--) {
            if (temp % 2 == 1) bit[i] = true;
            temp /= 2;
            if (temp == 1) {
                bit[i - 1] = true;
                break;
            }
        }
        // 如果是负数则转成补码
        if (flag) {
            // 转成反码
            for (int i = 0; i < bit.length; i++) {
                bit[i] = !bit[i];
            }
            // 转成补码
            // 记录是否进位
            boolean carry = true;
            int sub = bit.length - 1;
            while (sub >=0 && carry) {
                if (bit[sub]) {
                    bit[sub--] = false;
                } else {
                    bit[sub] = true;
                    carry = false;
                }
            }
        }
        // 统计 1 的个数
        int count = 0;
        for (boolean temp1 : bit) {
            if (temp1) count++;
        }
        return count;
    }

    /*
        无符号右移
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>>= 1;
        }
        return count;
    }
}
