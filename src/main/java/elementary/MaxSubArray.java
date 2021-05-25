package elementary;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArray {
    /*
        最大子序和
            给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     */

    /*
        动态规划
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(len);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            map.put(i, new HashMap<>());
            map.get(i).put(i, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!map.get(i).containsKey(j)) {
                    map.get(i).put(j, nums[j] + map.get(i).get(j - 1));
                }
                max = Math.max(max, map.get(i).get(j));
            }
        }
        return max;
    }
}
