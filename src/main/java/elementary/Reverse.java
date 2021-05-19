package elementary;

import java.util.ArrayList;

public class Reverse {
    /*
        整数反转
            给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果

            如果反转后整数超过 32 位的有符号整数的范围 [−2^31,2^31 − 1] ，就返回 0

            假设环境不允许存储 64 位整数（有符号或无符号）
     */

    /*
        将数字转换成字符串，然后颠倒字符串，在转成数字
     */
    public int reverse(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int left = x < 0 ? 1 : 0;
        int right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
        try {
            return Integer.parseInt(String.valueOf(s));
        } catch (Exception e) {
            return 0;
        }
    }

    /*
        逐个取出数字，然后颠倒
     */
    public static int reverse2(int x) {
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int j = 0;
        long result = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            result += Math.pow(10, i) * list.get(j++);
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    /*
        逐个取出数字，然后颠倒
            优化
     */
    public static int reverse3(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result != (int) result ? 0 : (int) result;
    }

}
