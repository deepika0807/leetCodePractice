package geeksforgeeks.Arrays.LeetCode;

import java.util.Arrays;

public class RemoveElement
{
    public static void main ( String [] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = nums.length;
        while (p1 < p2){
            if ( nums[p1] == val ){
                p2--;
                nums[p1]= nums[p2];
            }else{
                p1++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p1;
    }
}
