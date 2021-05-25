package elementary;

public class MaxProfit2 {
    /*
        买卖股票的最佳时机
            给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格

            你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润

            返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0

        示例 1：

            输入：[7,1,5,3,6,4]
            输出：5
            解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5
                 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票

        示例 2：

            输入：prices = [7,6,4,3,1]
            输出：0
            解释：在这种情况下, 没有交易完成, 所以最大利润为 0

     */

    /*
        穷举:
                 卖出 7  1  5  3  6  4
            买入
             7       # -6 -2 -4 -1 -3
             1       #  #  4  2  5  3
             5       #  #  # -2  1 -1
             3       #  #  #  #  3  1
             6       #  #  #  #  # -2
             4       #  #  #  #  #  #
     */

    /*
        动态规划
            dp[x][0] 表示第 x 天结束时没持有股票的最大利润
            dp[x][1] 表示第 x 天结束时持有股票的最大利润
            求 dp[x][0] 该怎么求
                情况一: 第x天什么都不做, dp[x][0] = dp[x - 1][0]
                情况二: 卖掉之前买的股票, dp[x - 1][1] + prices[x]
                由此可得 dp[x][0] = Math.max(dp[x - 1][0], dp[x - 1][1] + prices[x]);
            求 dp[x][1] 该怎么求
                情况一: 第x天之前买入股票 dp[x][1] = dp[x - 1][1]
                情况二: 第x天买入股票 dp[x][1] = -prices[x];
                由此可得 dp[x][1] = Math.max(dp[x - 1][1], -prices[x]);

     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int x = 1; x < len; x++) {
            dp[x][0] = Math.max(dp[x - 1][0], dp[x - 1][1] + prices[x]);
            dp[x][1] = Math.max(dp[x - 1][1], -prices[x]);
        }
        return dp[len - 1][0];
    }

    /*
        动态规划 优化
     */
    public int maxProfit1(int[] prices) {
        int hold = -prices[0],//持有股票
                noHold = 0;//不持有股票
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return noHold;
    }

    /*
        暴力解法
            找到股票最低点x,买入 -prices[x]
            买入后判断在那天卖出盈利最大
     */
    public int maxProfit2(int[] prices) {
        int buy = Integer.MAX_VALUE,
                maxProfit = 0;
        for (int price : prices) {
            if (buy > price) {
                buy = price;
            }
            int temp = price - buy;
            if (temp > maxProfit) {
                maxProfit = temp;
            }
        }
        return maxProfit;
    }
}
