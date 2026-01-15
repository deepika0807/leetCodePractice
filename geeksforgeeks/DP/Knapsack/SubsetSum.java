package geeksforgeeks.DP.Knapsack;

import java.util.Arrays;

public class SubsetSum
{
    static Boolean[][] t;
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 7, 8, 10};
//        System.out.println(subsetSum(arr, 5, 1));
        int sum = 11;
        int n = arr.length;
        // STEP 1: Allocate DP dynamically
        t = new Boolean[n + 1][sum + 1];

        // STEP 2: Initialize memo table
        for (Boolean[] row : t) {
            Arrays.fill(row, null);
        }
        System.out.println(subSetRecursion(arr, 11, 5));

    }

    public static boolean subSetRecursion(int[] arr, int sum, int n){
        if(t[n][sum] != null){
            return t[n][sum];
        }
        if (sum == 0) return t[n][sum] = true;
        if (n == 0) return t[n][sum] = false;

        if(arr[n-1] <= sum){
            t[n][sum] = subSetRecursion(arr, sum-arr[n-1], n-1) || subSetRecursion(arr, sum, n-1);
        }else{
            t[n][sum] =  subSetRecursion(arr, sum, n-1);
        }
        return t[n][sum];
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
