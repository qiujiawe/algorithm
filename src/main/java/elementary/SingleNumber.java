package elementary;

import java.util.Arrays;

public class SingleNumber {
    /*
        只出现一次的数字
            给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素

        说明：

        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    // 无脑解法
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 排序
        Arrays.sort(nums);
        // 处理: 当只出现一次的元素在数组边界时
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        // 处理: 当只出现一次的元素在数组非边界的位置时
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != nums[i + 1] && nums[i + 1] != nums[i + 2]) {
                return nums[i + 1];
            }
        }
        throw new IllegalArgumentException();
    }

    /*
        异或算法
            一个数字异或两个相同的数字,值不变
            一个数字异或 0 ,值不变
     */
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
