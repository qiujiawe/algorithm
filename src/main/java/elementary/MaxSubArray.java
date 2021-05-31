package elementary;

public class MaxSubArray {
    /*
        最大子序和
            给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     */

    /*
        穷举
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length,
                last = 0,
                max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                last = i == j ? nums[j] : last + nums[j];
                max = Math.max(max, last);
            }
        }
        return max;
    }

    /*
        动态规划
            1. 定义数组 dp[] , dp[i] 表示nums数组 0 ~ i 范围的最大子序和
            2. 计算 dp[i] 需要判断dp[i-1]是大于0还是小于0
                大于0: dp[i] = dp[i-1] + nums[i]
                小于0: dp[i] = nums[i]
     */
    public int maxSubArray1(int[] nums) {
        int len = nums.length,
                max = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
        动态规划
            优化
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length,
                max = nums[0],
                curr = nums[0];
        for (int i = 1; i < len; i++) {
            curr = curr > 0 ? curr + nums[i] : nums[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}
