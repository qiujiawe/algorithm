package elementary;

public class IsAnagram {
    /*
        有效的字母异位词
            给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

            示例 1:

            输入: s = "anagram", t = "nagaram"
            输出: true

            示例 2:

            输入: s = "rat", t = "car"
            输出: false

            说明:
            你可以假设字符串只包含小写字母。

            进阶:
            如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */

    /*
        暴力破解
     */
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        // 记录字符出现在字符串中的次数
        int[] ints = new int[123];
        // char数组获取字符效率高于 charAt() 方法
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < len; i++) {
            ints[chars[i]]++;
            ints[chars1[i]]--;
        }
        // 不等于0表示字符出现在两个字符串中的次数不一致
        for (int temp : ints) {
            if (temp != 0) {
                return false;
            }
        }
        return true;
    }

}
