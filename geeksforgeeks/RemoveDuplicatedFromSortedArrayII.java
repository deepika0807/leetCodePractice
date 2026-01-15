package geeksforgeeks;

import java.util.Arrays;

public class RemoveDuplicatedFromSortedArrayII
{
    public static void main (String args[])
    {
        //        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[] {0,0,0,1,1,1,1,2,3,3};
        int result = removeDuplicates(nums);
        System.out.println(result);


    }

    public static int removeDuplicates(int[] nums) {
       int i=0;
       for ( int currentNum: nums){
           if(i<2 || currentNum != nums[i-2]){
               nums[i] = currentNum;
               i++;
           }
       }
        return i;

    }
    public int removeDuplicatesTwoPointer(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int p1 = 2; // slow pointer starts at index 2

        for (int p2 = 2; p2 < nums.length; p2++) {
            // Only copy if current is not the same as nums[p1 - 2]
            if (nums[p2] != nums[p1 - 2]) {
                nums[p1] = nums[p2];
                p1++;
            }
        }

        return p1; // new length
        }
}
