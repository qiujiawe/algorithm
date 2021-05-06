public class LongestPalindrome {
    /*
        最长回文子串
            给你一个字符串 s，找到 s 中最长的回文子串

            示例 1：

                输入：s = "babad"
                输出："bab"
                解释："aba" 同样是符合题意的答案

            示例 2：

                输入：s = "cbbd"
                输出："bb"

            示例 3：

                输入：s = "a"
                输出："a"

            示例 4：

                输入：s = "ac"
                输出："a"
     */

    /*
        穷举法
            1. 遍历出所有字串
            2. 逐个判断是否为回文数
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int b = 0;
        int e = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (isPalindrome(arr, i, j)) {
                    if (e - b < j - i + 1) {
                        b = i;
                        e = j + 1;
                    }
                }
            }
        }
        return s.substring(b, e);
    }
    // 判断是否为回文串
    public static boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
        中心扩散法
            1. 遍历所有回文中心
                举例: 字符串 "abba" 的回文中心有 "a" , "ab" , "b" , "bb" , "b" , "ba"
            2. 以每个字符为中心，寻找以该字符为中心的最大回文串
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        char[] arr = s.toCharArray();
        int b = 0,
                e = 1;
        for (int i = 0; i < s.length(); i++) {
            // 获取扩展的最大次数
            int count1 = extension(arr, i, i),
                    count2 = extension(arr, i, i + 1);
            // 计算回文串长度
            int len1 = (i + count1) - (i - count1) + 1,
                    len2 = (i + 1 + count2) - (i - count2) + 1;
            int max = Math.max(len1, len2);
            if (max > e - b) {
                b = max == len1 ? i - count1 : i - count2;
                e = max == len1 ? i + count1 + 1 : i + 1 + count2 + 1;
            }
        }
        return s.substring(b, e);
    }
    // 获取中心能扩展的最大次数
    public static int extension(char[] arr, int left, int right) {
        int count = -1;
        while (left >= 0 && right <= arr.length - 1 && arr[left] == arr[right]) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    /*
        动态规划
            1. 遍历出所有长度等于2的字串
            2. 遍历的同时记录字串是否为回文串
            3. 在判断长度较长的字串是否为回文串时参考之前记录的字串 (较长的字串会含有以判断过的字串)
                例如: "babab" 判断该字符串是否为回文串只需要判断 arr[0] == arr[4] && db[0 + 1][4 - 1] == true 就行了
     */
    public static String longestPalindrome3(String s) {
        if (s == null) {
            return null;
        }
        char[] arr = s.toCharArray();
        int len = s.length();
        boolean[][] db = new boolean[len][len];
        int b = 0,
                e = 1;
        if (len < 2) {
            return s;
        }
        // l 为子串长度
        for (int l = 2; l <= len; l++) {
            // i 为字串最左边元素的下标
            for (int i = 0; i < len; i++) {
                // j 为字串最右边元素的下标
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                // 计算字串元素个数
                int size = j - i + 1;
                if (arr[i] != arr[j]) {
                    db[i][j] = false;
                } else {
                    if (size <= 3) {
                        db[i][j] = true;
                    } else {
                        // 参考字串中间部分是否为回文数
                        db[i][j] = db[i + 1][j - 1];
                    }
                }
                if (db[i][j] && size > e - b) {
                    b = i;
                    e = j + 1;
                }
            }
        }
        return s.substring(b,e);
    }

    public static void main(String[] args) {
    }

}
