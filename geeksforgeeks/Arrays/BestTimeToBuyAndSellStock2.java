package geeksforgeeks.Arrays;

public class BestTimeToBuyAndSellStock2
{
    public static void main(String[] args)
    {
        int[] nums = { 2,1,2,0,1 };
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit2(nums));
    }

    public static int maxProfit(int[] prices)
    {
        int bestTimeToBuy = prices[0], maxProfit = 0, res = 0;
        if (prices.length == 1)
        {
            return 0;
        }
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < bestTimeToBuy)
            {
                bestTimeToBuy = prices[i];
                if(i != 1){
                    res = res + maxProfit;
                    maxProfit = 0;
            }

            }
            else
            {
                int profit = prices[i] - bestTimeToBuy;
                if (profit < maxProfit)
                {
                    res = res + maxProfit;
                    bestTimeToBuy = prices[i];
                    maxProfit = 0;
                }
                else
                {
                    maxProfit = profit;
                }

            }

        }
        return res + maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


}
