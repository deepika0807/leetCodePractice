package geeksforgeeks.Arrays.LeetCode.KadanesAlgorithm;

import java.util.Arrays;

public class MaxSumSubArray
{
    public static void main(String[] args)
    {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }

//    Kadane's Algorithm
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int num: nums){
            currentSum += num;

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
//            Always set this value at the end to handle the negative array scenarios. For: {-1}
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
