package elementary;

public class StrStr {
    /*
        实现 strStr()
            给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1
            
            说明：

                当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
                
                对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
                
            示例 1：
            
                输入：haystack = "hello", needle = "ll"
                输出：2
            
            示例 2：
            
                输入：haystack = "aaaaa", needle = "bba"
                输出：-1
                
            示例 3：
            
                输入：haystack = "", needle = ""
                输出：0
            
            提示：
            
            0 <= haystack.length, needle.length <= 5 * 104
            haystack 和 needle 仅由小写英文字符组成
     */

    /*
        暴力解法

            int sub = -1;

            一直移动上指针

            ↓
            abcbcd
            ↓
            bcd

            检测到 上指针的值 与 下指针的值 一致时 一起移动指针 (记录下标)

            sub = 1
              ↓
            abcbcd
             ↓
            bcd

            检测到 不一致 且 sub != -1 时

            上指针移动到 sub + 1
            下指针移动到 0
            sub = -1;

              ↓
            abcbcd
            ↓
            bcd

     */
    public int strStr(String haystack, String needle) {
        int len1 = needle.length();
        if (len1 == 0) {
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        int len = chars.length;
        for (int top = 0; top <= len - len1; top++) {
            int i = top;
            int j = 0;
            while (chars[i++] == chars1[j++]) {
                if (j == len1) {
                    return top;
                }
            }
        }
        return -1;
    }


    /*
        KMP算法
     */
    public int strStr1(String haystack, String needle) {
        int len = haystack.length(),
                len1 = needle.length();
        if (len1 == 0) {
            return 0;
        }
        // 初始化前缀数组
        int[] pi = new int[len1];
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        /*
            获取前缀数组的流程

            pi{0}

            j i
            ↓ ↓
            a a b a a a b a a b a a a b

            pi{0,1}

              j i
              ↓ ↓
            a a b a a a b a a b a a a b

            j   i
            ↓   ↓
            a a b a a a b a a b a a a b

            pi{0,1,0}

            j     i
            ↓     ↓
            a a b a a a b a a b a a a b

              j   i
              ↓   ↓
            a a b a a a b a a b a a a b

            pi{0,1,0,1}

                j   i
                ↓   ↓
            a a b a a a b a a b a a a b

            pi{0,1,0,1,2}

                j     i
                ↓     ↓
            a a b a a a b a a b a a a b

              j       i
              ↓       ↓
            a a b a a a b a a b a a a b

            pi{0,1,0,1,2,2}

            ……

            pi{0,1,0,1,2,2,3,4,2,3,4,5,6,7}

         */
        for (int i = 1, j = 0; i < len1; i++) {
            while (j > 0 && chars1[i] != chars1[j]) {
                j = pi[j - 1];
            }
            if (chars1[i] == chars1[j]) {
                j++;
            }
            pi[i] = j;
        }
        /*
            原串:      c a a a b a a a b a a b a a a b
            模式串:    a a b a a a b a a b a a a b
            pi{0,1,0,1,2,2,3,4,2,3,4,5,6,7}

            i = 0
            j = 0

            ↓
            c a a a b a a a b a a b a a a b
            ↓
            a a b a a a b a a b a a a b

            --------------------------------------- 初始

            i = 0
            j = 0

              ↓
            c a a a b a a a b a a b a a a b
            ↓
            a a b a a a b a a b a a a b

            j = 0
            i = 1

            --------------------------------------- 第 1 次循环结束

            j = 0
            i = 1

                ↓
            c a a a b a a a b a a b a a a b
              ↓
            a a b a a a b a a b a a a b

            j = 1
            i = 2

            --------------------------------------- 第 2 次循环结束

            j = 1
            i = 2

                  ↓
            c a a a b a a a b a a b a a a b
                ↓
            a a b a a a b a a b a a a b

            j = 2
            i = 3

            --------------------------------------- 第 3 次循环结束

            j = 2
            i = 3

                  ↓
            c a a a b a a a b a a b a a a b
                ↓
            a a b a a a b a a b a a a b

            ---------------------------------------

            j > 0 && chars[i] != chars1[j] == false
            j = pi[j - 1] = 1

                  ↓
            c a a a b a a a b a a b a a a b
              ↓
            a a b a a a b a a b a a a b

            ----------------------------------------

                    ↓
            c a a a b a a a b a a b a a a b
                ↓
            a a b a a a b a a b a a a b

            j = 2
            i = 4

            --------------------------------------- 第 4 次循环结束

            ……

            return i - len1 + 1; --> return 16 - 14 + 1 --> return 3


         */
        for (int i = 0, j = 0; i < len; i++) {
            while (j > 0 && chars[i] != chars1[j]) {
                j = pi[j - 1];
            }
            if (chars[i] == chars1[j]) {
                j++;
            }
            if (j == len1) {
                return i - len1 + 1;
            }
        }
        return -1;
    }

}
