package geeksforgeeks.Arrays.LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Leetcode Question 15
//https://www.youtube.com/watch?v=cRBSOz49fQk&t=6s
public class IIISum
{
    public static void main ( String[] args){
        int[] nums ={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSumOptimised(nums));
        System.out.println(threeSumOptimisedWithTwist(nums, 3));
    }

//    Brute Force
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> response = new ArrayList<>();
//        for ( int i=0; i< nums.length; i++){
//            for ( int j= i+1; j< nums.length; j++){
//                for ( int k=j+1; k< nums.length; k++ ){
//                    if ( nums[i] + nums[j]+ nums[k] == 0 ){
//                        List<Integer> sum = new ArrayList<>() ;
//                        sum.add(nums[i]);
//                        sum.add( nums[j]);
//                        sum.add(nums[k]);
//                        Collections.sort(sum);
//                        if ( ! response.contains(sum) ){
//                            response.add(sum);
//                        }
//
//                    }
//                }
//            }
//        }
//        return response;
//    }
//    Optimised Solution
public static List<List<Integer>> threeSum(int[] nums)
{
    Arrays.sort(nums);
    Set<List<Integer>> response = new HashSet<>();
    for ( int i=0; i< nums.length-2; i++){
        int p1= i+1, p2= nums.length-1;
        while(p1< p2){
            if ( nums[p1]+nums[p2]== -nums[i]){
                response.add(Arrays.asList(nums[i], nums[p1], nums[p2]));

                p1++;
                p2--;
                while (p1 < p2 && nums[p1] == nums[p1 - 1]) p1++;
                while (p1 < p2 && nums[p2] == nums[p2 + 1]) p2--;
            }else if((nums[p1]+nums[p2]) > - nums[i]){
                p2--;
            }else{
                p1++;
            }
        }
    }
    return new ArrayList<> (response);
}

//https://www.youtube.com/watch?v=DhFh8Kw7ymk
    public static List<List<Integer>> threeSumOptimised(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        int p1 = 0;
        while (p1 <= n - 3) {
            // Skip duplicates for p1
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) {
                p1++;
                continue;
            }

            int p2 = p1 + 1, p3 = n - 1;
            while (p2 < p3) {
                int sum = nums[p1] + nums[p2] + nums[p3];

                if (sum > 0) {
                    p3--;
                } else if (sum < 0) {
                    p2++;
                } else {
                    result.add(Arrays.asList(nums[p1], nums[p2], nums[p3]));

                    // Skip duplicates for p2 and p3
                    while (p2 < p3 && nums[p2] == nums[p2 + 1]) p2++;
                    while (p2 < p3 && nums[p3] == nums[p3 - 1]) p3--;

                    p2++;
                    p3--;
                }
            }
            p1++;
        }
        return result;
    }


//    Three Sum with Twist

    public static List<List<Integer>> threeSumOptimisedWithTwist(int[] nums, int value) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i< nums.length-2; i++){
            if( i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            int tmp = value-nums[i];
            int p1= i+1, p2=nums.length-1;
            while(p1< p2){
                if(tmp-(nums[p1]+nums[p2]) == 0){
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    p1++;
                            p2--;
                    while (p1 < p2 && nums[p1] == nums[p1 - 1]) p1++;
                    while (p1 < p2 && nums[p2] == nums[p2 + 1]) p2--;
                }  else if( nums[p1]+nums[p2] >tmp){
                    p2--;

                }else{
                    p1++;
                }


            }



        }
        return result;
    }
}
