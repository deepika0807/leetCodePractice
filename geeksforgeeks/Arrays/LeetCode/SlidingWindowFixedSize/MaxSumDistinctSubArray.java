package geeksforgeeks.Arrays.LeetCode.SlidingWindowFixedSize;

import java.util.HashSet;
import java.util.Set;

public class MaxSumDistinctSubArray
{
    public static void main(String[] args){
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSubarraySumBruteForce(nums, k));
        System.out.println(maximumSubarraySumOptimised(nums, k));
    }

//    Time complexity -> O((n - k + 1) * k) ≈ O(n * k)
//    Space complexity -> 0(k)
    public static long maximumSubarraySumBruteForce(int[] nums, int k) {
        long maxValue = 0;
        boolean found = false;
        if (nums.length < k) return 0;
        for ( int i=0; i<= nums.length-k; i++){
            Set<Integer> numsSet = new HashSet<>();
            int sum =0;
            boolean isValid = true;
            for ( int j=i; j< k+i; j++ ){
                if( !numsSet.add(nums[j])){
                    isValid = false;
                    break;
                }

                    sum += nums[j];
            }
            if (isValid) {
                found = true;
                maxValue = Math.max(maxValue, sum);
            }
        }
        return found ? maxValue : 0;
    }

    public static long maximumSubarraySumOptimised(int[] nums, int k)
    {
        Set<Integer> window = new HashSet<>();
        long maxSum = 0, sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++)
        {
            // Shrink window if duplicate found
            while (window.contains(nums[right]))
            {
                window.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add current element
            window.add(nums[right]);
            sum += nums[right];

            // When window size reaches k
            if (right - left + 1 == k)
            {
                maxSum = Math.max(maxSum, sum);
                // Slide window forward
                window.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
