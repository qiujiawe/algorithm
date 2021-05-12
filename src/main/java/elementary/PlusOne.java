package elementary;

public class PlusOne {
    /*
        加一
            给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一

            最高位数字存放在数组的首位， 数组中每个元素只存储单个数字

            你可以假设除了整数 0 之外，这个整数不会以零开头

        示例 1：

            输入：digits = [1,2,3]
            输出：[1,2,4]
            解释：输入数组表示数字 123

        示例 2：

            输入：digits = [4,3,2,1]
            输出：[4,3,2,2]
            解释：输入数组表示数字 4321

        示例 3：

            输入：digits = [0]
            输出：[1]

        提示：

            1 <= digits.length <= 100
            0 <= digits[i] <= 9

     */

    /*
        暴力
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flag;
        int i = 0;
        do {
            if (len - 1 - i == -1) {
                int[] result = new int[len + 1];
                result[0] = 1;
                System.arraycopy(result,1,digits,0,len);
                return result;
            }
            flag = digits[len - 1 - i] + 1 == 10;
            digits[len - 1 - i] = flag ? 0 : digits[len - 1 - i] + 1;
            i++;
        } while (flag);
        return digits;
    }

}
