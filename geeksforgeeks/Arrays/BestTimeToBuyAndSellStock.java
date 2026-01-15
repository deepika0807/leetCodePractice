package geeksforgeeks.Arrays;

public class BestTimeToBuyAndSellStock
{
    public static void main(String[] args)
    {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfitBruteForce(prices));
        System.out.println(maxProfitOptimised(prices));

    }

    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++){
            int interMaxProfit = 0;
            for (int j=i+1; j< prices.length; j++){
                int profit = prices[j] - prices[i];
                interMaxProfit = Math.max(interMaxProfit, profit);
            }
            maxProfit= Math.max(maxProfit, interMaxProfit);
        }
        return maxProfit;
    }
    public static int maxProfitOptimised(int[] prices) {
        int maxProfit = 0, bestBuy = prices[0];
        for (int i=1; i<prices.length; i++){
            bestBuy = Math.min(bestBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
        }
        return maxProfit;
    }
}
