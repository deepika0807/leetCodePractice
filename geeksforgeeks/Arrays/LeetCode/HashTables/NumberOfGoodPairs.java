package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
        System.out.println(numIdenticalPairsBruteForce(nums));
    }

//    The pattern recognition trick
//
//When you see:
//
//A problem asking to count pairs where elements are equal →
//👉 Always think frequency counting.
//
//Formula for pairs from k items → k * (k-1) / 2.
//
//Or do it iteratively → each time you see a value again, it pairs with all its earlier occurrences.
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int pairsCount =0;
        for ( int i=0; i< nums.length; i++){
            int count = freqMap.getOrDefault(nums[i], 0);
            pairsCount += count; // FreqCount(n) + pairsCount(n)
            freqMap.put(nums[i], count+1);
        }
        return pairsCount;
    }

    public static int numIdenticalPairsBruteForce(int[] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();

        for ( int i=0; i< nums.length; i++){
            for( int j= i+1; j< nums.length; j++){
                if( nums[i] ==  nums[j]){
                    freqMap.put(i, j);
                }
            }
        }
        System.out.println(freqMap);
        return freqMap.size();
    }

    public int numIdenticalPairsOptimised2(int[] nums) {
        // Use a frequency map to count occurrences of each number
        int[] freq = new int[101]; // since nums[i] is 1 <= nums[i] <= 100 (per problem constraints)
        int count = 0;

        for (int n : nums) {
            // For each new occurrence, it forms 'freq[n]' pairs with previous ones
            count += freq[n];
            freq[n]++;
        }

        return count;
    }
}
