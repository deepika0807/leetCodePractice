package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

public class IndexesOfSubarraySum
{
    /***
     * Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.
     * Note: If no such array is possible then, return [-1].
     * Input: arr[] = [1, 2, 3, 7, 5], target = 12
     * Output: [2, 4]
     * Explanation: The sum of elements from 2nd to 4th position is 12.
     * @param args
     */

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 7, 5};

        ArrayList<Integer> subArray = subarraySum(arr, 12);
        if ( subArray.get(0) == -1){
            System.out.println(-1);
        }else{
            System.out.println( Arrays.asList(subArray));
        }
    }

    static ArrayList<Integer> subarraySum(int[] arr, int target)
    {
        ArrayList<Integer> subArrayIndexes = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            int sum = 0;
            int counter = i;
            while ( sum < target && counter < arr.length){
                sum = sum + arr[counter];
                if ( sum == target){
                    subArrayIndexes.add(i+1);
                    subArrayIndexes.add(counter + 1);
                    return subArrayIndexes;
                }
                counter ++;
            }
    }
        subArrayIndexes.add(-1);
        return subArrayIndexes;
}
}
