package geeksforgeeks.Arrays;

import java.util.Arrays;
// This is Prefix/Suffix problem
//https://www.youtube.com/watch?v=G9zKmhybKBM&t=118s
public class ProductOfArrayExceptItself
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelfBruteForce(nums)));
        System.out.println(Arrays.toString(productExceptSelfOptimised(nums)));

    }

//    Brute Force Approach
    public static int[] productExceptSelfBruteForce(int[] nums) {
        int[] response = new int[nums.length];
        for ( int i=0; i< nums.length; i++ ){
            int value = 1;
            for( int j=0; j<nums.length; j++ ){
                if( i!=j )
                value = value*nums[j];
            }
            response[i] = value;
        }
        return response;
    }

    public static int[] productExceptSelfOptimised(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for ( int i=1; i< nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int suffix = 1;
        for ( int i= nums.length-2; i>=0; i--){
            suffix = suffix * nums[i+1];
            res[i] = res[i] * suffix;

        }
        return res;

    }
}
