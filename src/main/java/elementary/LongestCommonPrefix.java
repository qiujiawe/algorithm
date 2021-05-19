package elementary;

public class LongestCommonPrefix {
    /*
        最长公共前缀
            编写一个函数来查找字符串数组中的最长公共前缀

            如果不存在公共前缀，返回空字符串 ""

            示例 1：

            输入：strs = ["flower","flow","flight"]
            输出："fl"
            示例 2：

            输入：strs = ["dog","racecar","car"]
            输出：""
            解释：输入不存在公共前缀。
             

            提示：

            0 <= strs.length <= 200
            0 <= strs[i].length <= 200
            strs[i] 仅由小写英文字母组成

     */

    /*
        暴力解法
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        int currCommSub = 0;
        char[] chars = strs[0].toCharArray();
        char[] chars1 = strs[1].toCharArray();
        while (currCommSub < chars.length && currCommSub < chars1.length && chars[currCommSub] == chars1[currCommSub]) {
            currCommSub++;
        }
        for (int i = 2; i < len; i++) {
            char[] temp = strs[i].toCharArray();
            int j = 0;
            while (j < currCommSub && j < temp.length && chars[j] == temp[j]) {
                j++;
            }
            currCommSub = Math.min(j, currCommSub);
        }
        return currCommSub == 0 ? "" : String.valueOf(chars, 0, currCommSub);
    }

    /*
        暴力解法
            优化
     */
    public String longestCommonPrefix1(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        String pre = strs[0];
        int len1 = pre.length();
        for (int j = 1; j < len; j++) {
            while (strs[j].indexOf(pre) != 0) {
                pre = pre.substring(0,--len1);
            }
        }
        return pre;
    }
}
