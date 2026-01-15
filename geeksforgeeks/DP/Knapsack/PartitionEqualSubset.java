package geeksforgeeks.DP.Knapsack;

import java.util.Arrays;

public class PartitionEqualSubset
{
    static Boolean[][] t;
    public static void main(String[] args)
    {
        int[]  nums = { 1, 5, 11, 5 };
        int sum = 0;
//        System.out.println(partitionEqualSubset(arr));
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0){
            System.out.println(false);
        }else{
            // STEP 1: Allocate DP dynamically
            t = new Boolean[nums.length + 1][sum/2 + 1];

            // STEP 2: Initialize memo table
            for (Boolean[] row : t) {
                Arrays.fill(row, null);
            }
        System.out.println(partitionEqualSubsetRecurive(nums, sum/2, nums.length));
        }
    }
    public static boolean partitionEqualSubsetRecurive(int[] nums, int sum, int n){
            if(t[n][sum] != null){
                return t[n][sum];
            }
            if (sum == 0) return t[n][sum] = true;
            if (n == 0) return t[n][sum] = false;

            if(nums[n-1] <= sum){
                t[n][sum] = partitionEqualSubsetRecurive(nums, sum-nums[n-1], n-1) || partitionEqualSubsetRecurive(nums, sum, n-1);
            }else{
                t[n][sum] =  partitionEqualSubsetRecurive(nums, sum, n-1);
            }
            return t[n][sum];
    }


    public static boolean partitionEqualSubset(int[] nums){
        int sum =0 ;
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0){
            return false;
        }else{
            return subsetSum(nums, nums.length, sum/2);
        }
    }
    public static boolean subsetSum(int[] arr, int n, int sum){
        boolean[][] t = new boolean[n+1][sum+1];

        //         Intitialisation (Base Condition)
        for(int i=0; i< n+1; i++){
            for(int j=0; j< sum+1; j++){
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }


        for(int i=1; i< n+1; i++){
            for(int j=1; j< sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
