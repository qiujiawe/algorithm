package elementary;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
        两数之和
            给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标

            你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现

            你可以按任意顺序返回答案
     */

    /*
        哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i = 1; i < len; i++) {
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget)) {
                return new int[]{i,map.get(newTarget)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}
