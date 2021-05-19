package elementary;

public class CountAndSay {
    /*
        外观数列
            给定一个正整数 n ，输出外观数列的第 n 项

            「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述

            你可以将其视作是由递归公式定义的数字字符串序列：

            countAndSay(1) = "1"
            countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串

            前五项如下：

            1.     1
            2.     11
            3.     21
            4.     1211
            5.     111221
            第一项是数字 1
            描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
            描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
            描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
            描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
            要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。
            然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。

     */

    /*
        暴力解法
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "11";
        for (int i = 3; i <= n; i++) {
            char[] chars = result.toCharArray();
            StringBuilder temp = new StringBuilder();
            // 成员,例如字符串 "11223" 成员有 "1" "2" "3"
            char member = '#';
            // 成员出现的次数
            int number = 1;
            for (char aChar : chars) {
                if (member == aChar) {
                    number++;
                } else {
                    if (member != '#') {
                        temp.append(number).append(member);
                        number = 1;
                    }
                    member = aChar;
                }
            }
            temp.append(number).append(member);
            result = temp.toString();
        }
        return result;
    }

    /*
        双指针
     */
    public String countAndSay1(int n) {
        StringBuilder result = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            char[] chars = result.toString().toCharArray();
            int len = chars.length;
            result.delete(0, len);
            int slow = 0;
            int fast = 1;
            for (; fast < chars.length; fast++) {
                if (chars[slow] != chars[fast]) {
                    result.append(fast - slow).append(chars[slow]);
                    slow = fast;
                }
            }
            result.append(fast - slow).append(chars[slow]);
        }
        return result.toString();
    }

    /*
        递归 + 双指针
     */
    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay2(n - 1);
        StringBuilder result = new StringBuilder();
        char[] chars = last.toCharArray();
        int slow = 0,
                fast = 1;
        for (; fast < chars.length; fast++) {
            if (chars[slow] != chars[fast]) {
                result.append(fast - slow).append(chars[slow]);
                slow = fast;
            }
        }
        result.append(fast - slow).append(chars[slow]);
        return result.toString();
    }

}
