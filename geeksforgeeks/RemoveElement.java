package geeksforgeeks;

import java.util.Arrays;

/**
 Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

 Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

 Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 Return k.


 Input: nums = [3,2,2,3], val = 3
 Output: 2, nums = [2,2,_,_]
 Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 It does not matter what you leave beyond the returned k (hence they are underscores).


 **/

public class RemoveElement
{
    public static void main (String args[])
{
    int[] nums = new int[] {0,1,2,2,3,0,4,2 };
//    int[] nums = new int[] {1};
//    int[] nums = new int[]{3,2,2,3};
    int val = 2;
    int result = removeElement(nums, val);
    System.out.println(result);


}

    public static int removeElement(int[] nums, int val) {
//        int p1 = 0; // Pointer for the current position to check
//        int p2 = nums.length; // Pointer for the length of the modified array
//
//
//        while (p1 < p2) {
//            if (nums[p1] == val) {
//                // Replace the current element with the last element
//                p2--; // Reduce the effective size of the array
//                nums[p1] = nums[p2]; // Move the last element to current position
//            } else {
//                p1++; // Move to the next element
//            }
//        }
//        return p2;
        int p1 = 0;
        int p2 = nums.length;
        while( p1 < p2 ){
            if(nums[p1] == val)
            {
                p2--;
                nums[p1] = nums[p2];

            }
            else{
                p1 ++;}
        }

        System.out.println(Arrays.toString(nums));
        return p1;


        }

}

