package elementary;

import java.util.*;

public class Intersect {
    /*
        两个数组的交集 II
            给定两个数组，编写一个函数来计算它们的交集

     */

    /*
        穷举
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length,
                len2 = nums2.length;
        if (len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp1 = len1;
            len1 = len2;
            len2 = temp1;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j] && !flag[j]) {
                    list.add(nums1[i]);
                    flag[j] = true;
                    break;
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /*
        排序,双指针
            1. 先对两个数组进行排序
            2. 从头开始逐个比较两个数组中的元素

            举例:

             ↓ - 指针 x
            [1,3,8,8]
             ↓ - 执行 y
            [2,4,8]

            比较两个指针指向的元素 1 < 2 , x 向右移动

               ↓ - 指针 x
            [1,3,8,8]
             ↓ - 执行 y
            [2,4,8]

            比较两个指针指向的元素 3 > 2 , y 向右移动

               ↓ - 指针 x
            [1,3,8,8]
               ↓ - 执行 y
            [2,4,8]

            比较两个指针指向的元素 3 < 4 , x 向右移动

                 ↓ - 指针 x
            [1,3,8,8]
               ↓ - 执行 y
            [2,4,8]

            比较两个指针指向的元素 8 > 4 , y 向右移动

                 ↓ - 指针 x
            [1,3,8,8]
                 ↓ - 执行 y
            [2,4,8]

            比较两个指针指向的元素 8 == 8 , y,x 向右移动 记录元素8

            y达到数组边界，停止比较。返回记录的元素

     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int x = 0;
        int y = 0;
        int j = 0;
        int[] arr = new int[nums1.length];
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] < nums2[y]) {
                x++;
            } else if (nums1[x] > nums2[y]) {
                y++;
            } else {
                arr[j++] = nums1[x];
                x++;
                y++;
            }
        }
        return Arrays.copyOfRange(arr, 0, j);
    }

    /*
        哈希表
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        int[] arr = new int[nums1.length];
        int k = 0;
        for (int j : nums1) {
            int temp = map.containsKey(j) ? map.get(j) + 1 : 1;
            map.put(j, temp);
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                arr[k++] = j;
                map.put(j, map.get(j) - 1);
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

}
