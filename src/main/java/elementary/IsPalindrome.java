package elementary;

public class IsPalindrome {
    /*
        验证回文串
            给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写

            说明：本题中，我们将空字符串定义为有效的回文串

            示例 1:

                输入: "A man, a plan, a canal: Panama"
                输出: true

            示例 2:

                输入: "race a car"
                输出: false
     */

    /*
        双指针
     */
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 预处理
        for (int i = 0; i < len; i++) {
            pretreatment(chars, i);
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (chars[left] == 0) {
                left++;
                continue;
            }
            if (chars[right] == 0) {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private static void pretreatment(char[] chars, int sub) {
        if (chars[sub] >= 65 && chars[sub] <= 90) {
            chars[sub] += 32;
        } else if (!(chars[sub] >= 48 && chars[sub] <= 57)
                && !(chars[sub] >= 97 && chars[sub] <= 122)
        ) {
            chars[sub] = 0;
        }
    }

}
