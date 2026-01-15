package geeksforgeeks.Arrays.LeetCode.KadanesAlgorithm;

public class MaxProductSubArray
{
    public static void main(String[] args)
    {
        int[] nums ={-2,3,-4};
        System.out.println(maxSubarraySumCircular(nums));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int maxProduct = nums[0];
        int currentProduct = nums[0];
        if(currentProduct==0){
            currentProduct = 1;
        }
        for(int i=1; i< nums.length; i++){
            currentProduct = currentProduct * nums[i];
            maxProduct = Math.max(maxProduct, currentProduct);
            if(currentProduct == 0){
                currentProduct = 1;
            }
        }
        return maxProduct;
    }
}
