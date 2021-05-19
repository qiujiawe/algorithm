package elementary;

public class MaxProfit {
    /*
        买卖股票的最佳时机 II

            给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格

            设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）

            注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）

        示例 1:

            输入: prices = [7,1,5,3,6,4]
            输出: 7
            解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
                随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3

        示例 2:

            输入: prices = [1,2,3,4,5]
            输出: 4
            解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
                注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票

        示例3:

            输入: prices = [7,6,4,3,1]
            输出: 0
            解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
     */


    /*
        暴力解法
            1. 如果第i天的价格低于第(i - 1)天的价格
            2. 则计算 prices[i + 1] - prices[i] 的值并记录
            3. 然后将记录的值相加，返回
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    /*
        参考力扣题解的解法
            1. 在最佳买入点买入,当第i天的价格低于第(i - 1)天的价格时就是最佳买入点
            2. 在最佳卖出点卖出,当第i天的价格高于于第(i - 1)天的价格时就是最佳买入点

        相比于上面那种写法，省去了一些计算
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0,
                len = prices.length,
                i = 0;
        while (i < len) {
            // 寻找最佳买入点
            while (i < len - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            // 最佳买入点
            int buy = prices[i];
            // 寻找最佳卖出点
            while (i < len - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            // 交易
            profit += prices[i++] - buy;
        }
        return profit;
    }
}
