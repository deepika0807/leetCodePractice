package geeksforgeeks;

public class BuySellStockMaxProfit
{
    public static void main (String args[])
    {
        int[] nums = new int[] {1,2,4,2,5,7,2,4,9,0,9};
        int result = maxProfit(nums);
        System.out.println(result);

    }

    public static int maxProfit(int[] prices)
    {
        int maxProfit = 0;
        int p1 = 0;
        int p2 = 1;
        while(p2 <= prices.length-1 ){
            if( prices[p2]-prices[p1] > maxProfit ){
                maxProfit = prices[p2]-prices[p1] ;

            }else if ( prices[p2]-prices[p1] <= 0 ){
                p1++;
            }
            p2++;
        }
     return  maxProfit;
    }
}
