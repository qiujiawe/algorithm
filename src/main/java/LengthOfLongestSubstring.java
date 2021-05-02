import java.util.*;

public class LengthOfLongestSubstring {

    /*
        给定一个字符串，请你找出其中不含有重复字符的最长子串的长度

            示例1:

                输入: s = "abcabcbb"
                输出: 3
                解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3

            示例 2:

                输入: s = "bbbbb"
                输出: 1
                解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1

            示例 3:

                输入: s = "pwwkew"
                输出: 3
                解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3
                    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串

            示例 4:

                输入: s = ""
                输出: 0

     */

    /*
        穷举法
            遍历出所有字串,然后判断是否有重复字符
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int l = s.length(); l >= 2; l--) {
            for (
                    int i = 0, j = l;
                    j < s.length() + 1;
                    i++, j++
            ) {
                String sub = s.substring(i, j);
                String[] subArr = sub.split("");
                int len = subArr.length;
                long newLen = Arrays.stream(subArr).distinct().count();
                if (len == newLen) {
                    System.out.println(sub);
                    return len;
                }
            }
        }
        return 1;
    }

    /*
        滑动窗口
            已 pwwkew 举例:
                1. 遍历
                    1. [p]wwkew
                    2. [pw]wkew
                    3. pw[w]kew 检测到重复字符 [ 移动到重复字符的右边 记录第2步滑动窗口中元素的个数
                    4. pw[wk]ew
                    5. pw[wke]w
                    6. pww[kew] 检测到重复字符 [ 移动到重复字符的右边 记录第5步滑动窗口中元素的个数
                2. 记录第6步滑动窗口中元素的个数
                3. 比较3个记录的长度,返回最大的
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        // 用来储存字符
        Map<Character, Integer> map = new HashMap<>();
        // 第一个字符前肯定没有重复字符
        map.put(s.charAt(0), 0);
        // 表示 [ ,即满指针
        int slow = 0,
        // 用来记录滑动窗口中元素的个数
            max = 1;
        // 遍历
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int index = map.get(s.charAt(i));
                if (index >= slow) {
                    max = Math.max(max, i - slow);
                    slow = index + 1;
                }
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(max, s.length() - slow);
    }

    /*
        力扣官方的滑动窗口
            [pw]wkew 记录 2
            [w]wkew 记录 1
            [w]kew
            [wk]ew
            [wke]w 记录 3
            [k]ew
            [ke]w
            ……
     */
    public static int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abbac"));
    }

}
