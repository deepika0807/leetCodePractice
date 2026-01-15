package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicatesII
{
    public static void main(String[] args)
    {
        int[] nums ={1,2,3,1,2,3};
        int k=2;
        System.out.println(containsNearbyDuplicate(nums, k));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for ( int i=0; i< nums.length; i++ ){
            if(freqMap.containsKey(nums[i])){
                int diffValue = Math.abs(i-freqMap.get(nums[i]));
                if(diffValue <= k){
                    return true;
                }
            }
            freqMap.put(nums[i], i);


        }

        return false;
    }

}
