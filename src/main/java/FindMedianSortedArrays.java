import java.util.*;

public class FindMedianSortedArrays {
    /*
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数

        示例 1：

            输入：nums1 = [1,3], nums2 = [2]
            输出：2.00000
            解释：合并数组 = [1,2,3] ，中位数 2

        示例 2：

            输入：nums1 = [1,2], nums2 = [3,4]
            输出：2.50000
            解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

        示例 3：

            输入：nums1 = [0,0], nums2 = [0,0]
            输出：0.00000

        示例 4：

            输入：nums1 = [], nums2 = [1]
            输出：1.00000

        示例 5：

            输入：nums1 = [2], nums2 = []
            输出：2.00000

     */

    /*
        无脑解法
            合并数组
            排序
            找出中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        result = Arrays.stream(result).sorted().toArray();
        return result.length % 2 == 0 ? (double) (result[result.length / 2] + result[(result.length / 2) - 1]) / 2 : result[result.length / 2];
    }

    /*
        二分查找法
            1. 分割两个数组
                要求:
                    1. 分割后左右两边元素的个数
                        两个数组的元素个数之和为奇数时，左边元素个数之和 比 右边元素个数之和 多一个
                        两个数组的元素个数之和为偶数时，左边元素个数之和 等于 右边元素个数之和
                    2. 左边最大的元素 要小于 右边最小的元素
            2. 返回中位数
                两个数组的元素个数之和为奇数时，中位数就是 左边元素的最大值
                两个数组的元素个数之和为偶数时，中位数就是 (左边元素的最大值 + 右边元素的最小值) / 2

                例如:
                    3 8 | 9 10
                    2 4 6 | 12 18 20

                    两个数组元素个数之和为 偶数
                    左边元素个数之和: 5
                    右边元素个数之和: 5
                    左边最大的元素: 8
                    右边最小的元素: 9
                    中位数: (8 + 9) / 2

                例如:
                    2 4 6 | 15
                    1 7 | 8 10 17

                    两个数组元素个数之和为 奇数
                    左边元素个数之和: 5
                    右边元素个数之和: 4
                    左边最大的元素: 7
                    右边最小的元素: 8
                    中位数: 7

                例如:
                    1 2 3 | 4 5
                    0 0 | 0 0

                    两个数组元素个数之和为 奇数
                    左边元素个数之和: 5
                    右边元素个数之和: 4
                    左边最大的元素: 1
                    右边最小的元素: 2
                    中位数: 1


    */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 把元素个数少的放在nums1
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length,
                m = nums2.length;
        // 给分割线一个初始位置

        // 例如:      1  2  3  |  4  5  6
        // 索引:      0  1  2     3  4  5
        // 分割线索引:0  1  2  3     4  5  6

        // 例如:      1  2 |  3
        // 索引:      0  1    2
        // 分割线索引:0  1  2    3

        // 例如:      1 |
        // 索引:      0
        // 分割线索引:0  1

        int cutOff1 = (n + 1) / 2,
                cutOff2 = (n + m + 1) / 2 - cutOff1;
        // 为了防止越界问题
        int upperLeft = cutOff1 - 1 < 0 ? Integer.MIN_VALUE : nums1[cutOff1 - 1],
                lowLeft = cutOff2 - 1 < 0 ? Integer.MIN_VALUE : nums2[cutOff2 - 1],
                upperRight = cutOff1 >= n ? Integer.MAX_VALUE : nums1[cutOff1],
                lowRight = cutOff2 >= m ? Integer.MAX_VALUE : nums2[cutOff2];
        // 获取分割线左边最大的元素
        int leftMax = Math.max(upperLeft, lowLeft);
        // 获取分割线右边最小的元素
        int rightMin = Math.min(upperRight, lowRight);
        // 判断分割线是否符合要求
        while (!(leftMax <= rightMin)) {
            // 走到这里说明 leftMax > rightMin 不符合要求
            // 要移动分割线
            if (upperLeft > lowRight) {
                if (cutOff1 == 0) {
                    // 如果分割线在边界,则只移动较长的数组
                    cutOff2 += 2;
                } else {
//                    例如:
//                        1 [2] | 3 4
//                        0 0 | [0] 0
                    cutOff1--;
                    cutOff2++;
                }
            }
            if (lowLeft > upperRight) {
                if (cutOff1 == n) {
                    cutOff2 -= 2;
                } else {
//                    例如:
//                    0 0 | [0] 0
//                    1 [2] | 3 4
                    cutOff1++;
                    cutOff2--;
                }

            }
            upperLeft = cutOff1 - 1 < 0 ? Integer.MIN_VALUE : nums1[cutOff1 - 1];
            lowLeft = cutOff2 - 1 < 0 ? Integer.MIN_VALUE : nums2[cutOff2 - 1];
            upperRight = cutOff1 >= n ? Integer.MAX_VALUE : nums1[cutOff1];
            lowRight = cutOff2 >= m ? Integer.MAX_VALUE : nums2[cutOff2];
            leftMax = Math.max(upperLeft, lowLeft);
            rightMin = Math.min(upperRight, lowRight);
        }
        if ((n + m) % 2 == 0) {
            // 偶数
            return (double) (leftMax + rightMin) / 2;
        } else {
            // 奇数
            return leftMax;
        }
    }

}
