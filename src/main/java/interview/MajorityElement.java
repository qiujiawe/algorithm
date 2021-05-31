package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /*
        多数元素
            给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

            你可以假设数组是非空的，并且给定的数组总是存在多数元素
     */

    /*
        暴力解法
     */
    public int majorityElement(int[] nums) {
        int len = nums.length,
                half = len / 2;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            if (value > half) return num;
            map.put(num, value);
        }
        throw new IllegalArgumentException();
    }

    /*
        排序后,中间的元素就是最多的元素
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
        摩尔投票法
            把两个不同的元素当做不存在
     */
    public int majorityElement2(int[] nums) {
        int curr = nums[0],
                count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                curr = nums[i];
                count++;
                continue;
            }
            count = curr != nums[i] ? count - 1 : count + 1;
        }
        return curr;
    }
}
