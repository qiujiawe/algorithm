package elementary;

import java.util.*;

public class FirstUniqChar {
    /*
        字符串中的第一个唯一字符
            给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
     */

    /*
        双指针,哈希表
     */
    public static int firstUniqChar(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        boolean[] flag = new boolean[len];
        Map<Character, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int show = 0;
        for (int i = 1; i < len; i++) {
            if (map.containsKey(arr[i])) {
                flag[i] = true;
                flag[map.get(arr[i])] = true;
                while (flag[show]) {
                    show++;
                    if (show == len) {
                        return -1;
                    }
                }
            }
            map.put(arr[i], i);
        }
        return show;
    }

    /*
        使用java自带的 lastIndexOf 方法
            如果一个字符最后出现的位置与第一次出现的位置一致,则表示该字符只出现过一次
     */
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (s.indexOf(currChar) == s.lastIndexOf(currChar)) {
                return i;
            }
        }
        return -1;
    }

    /*
        用数组来记录
            字符是否出现,重复出现
            字符的索引
     */
    public int firstUniqChar3(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        if (len == 1) {
            return 0;
        }
        // 0 表示没出现过
        // -1 表示出现过两次
        // 其他 表示出现过一次,且值为索引 + 1
        int[] arr = new int[26];
        for (int i = 0; i < len; i++) {
            int sub = chars[i] - 97;
            if (arr[sub] == 0) {
                // 没出现过
                arr[sub] = i + 1;
            } else {
                arr[sub] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int temp : arr) {
            if (temp > 0) {
                min = Math.min(min,temp);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min - 1;
    }

    /*
    用数组来记录
        字符是否出现,重复出现
        字符的索引
 */
    public int firstUniqChar4(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] data = new int[26];
        for (char aChar : chars) {
            data[aChar - 97]++;
        }
        for (int i = 0; i < len; i++) {
            if (data[chars[i] - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar5(String s) {
        int resulet = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                if (resulet == -1 || resulet > s.indexOf(c)) {
                    resulet = s.indexOf(c);
                }
            }
        }
        return resulet;
    }
}
