package geeksforgeeks.Arrays;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray
{
    public static void main(String[] args)
    {
        int[] nums1 ={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums1));
        int[] nums2 ={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesII(nums2));
    }

    public static int removeDuplicates(int[] nums) {
        int p1=0, p2=1;
        while(p2 < nums.length){
            if(nums[p1] == nums[p2]){
                p2++;
            }else{
                nums[p1+1] = nums[p2];
                p1++;
                p2++;
            }
        }
        return p1+1;
    }

    public static int removeDuplicatesII(int[] nums) {
        int p1=2, p2=2;
        while(p2 < nums.length){
            if(nums[p2] != nums[p1-2]){
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }
        System.out.println(Arrays.toString(nums));
        return p1;
    }
}
