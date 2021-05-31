package elementary;

public class Rob {
    /*
        打家劫舍
            你是一个专业的小偷，计划偷窃沿街的房屋。
            每间房内都藏有一定的现金，
            影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
            如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

            给定一个代表每个房屋存放金额的非负整数数组，
            计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额

        示例 1：

            输入：[1,2,3,1]
            输出：4
            解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
                偷窃到的最高金额 = 1 + 3 = 4 。

        示例 2：
            输入：[2,7,9,3,1]
            输出：12
            解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
                偷窃到的最高金额 = 2 + 9 + 1 = 12 。

     */

    /*
        动态规划
            定义数组 dp[][]
                第一个[]表示第几家, [1] 表示 第1家
                第二个[],[0] 表示没偷,[1] 表示偷了
            求 Math.max(dp[i][0],dp[i][1]);

            [2,7,9,3,1]
            dp[0][0] = 0;
            dp[0][1] = 2;
            dp[1][0] = Math.max(dp[i - 1][0],dp[i - 1][1])
            dp[1][1] = dp[i - 1][0] + nums[1];
            dp[2][0] = Math.max(dp[i - 1][0],dp[i - 1][1])
            dp[2][1] = dp[i - 1][0] + nums[2]
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    /*
        动态规划
            优化
     */
    public int rob1(int[] nums) {
        int noSteal = 0,
                steal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = noSteal;
            noSteal = Math.max(temp, steal);
            steal = temp + nums[i];
        }
        return Math.max(noSteal, steal);
    }

}
