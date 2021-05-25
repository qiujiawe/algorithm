package elementary;

import java.util.Arrays;

public class Merge {
    /*
        合并两个有序数组
            给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

            初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
            这样它就有足够的空间保存来自 nums2 的元素。

     */

    /*
        暴力解法
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < m + n) {
            if (i == m) {
                nums1[count++] = nums2[j++];
                continue;
            } else if (j == n) {
                nums1[count++] = temp[i++];
                continue;
            }
            if (temp[i] < nums2[j]) {
                nums1[count++] = temp[i++];
            } else {
                nums1[count++] = nums2[j++];
            }
        }
    }

    /*
        暴力解法2
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int count = 0;
        int len = nums1.length;
        while (!(i == -1 || j == -1)) {
            int sub = len - 1 - count++;
            if (nums1[i] < nums2[j]) {
                nums1[sub] = nums2[j--];
            } else {
                nums1[sub] = nums1[i--];
            }
        }
        if (i == -1) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }

    /*
        官方api
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /*
        参考归并
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) {
                nums1[index++] = temp[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }
        if (!(i < m)) {
            System.arraycopy(nums2, j, nums1, index, n - j);
        } else {
            System.arraycopy(temp, i, nums1, index, m - i);
        }
    }

}
