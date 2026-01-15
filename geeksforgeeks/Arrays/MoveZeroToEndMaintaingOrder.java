package geeksforgeeks.Arrays;

import java.util.Arrays;

//https://www.youtube.com/watch?v=V0vmGwinHrg
public class MoveZeroToEndMaintaingOrder
{
    public static void main(String[] args)
    {
        int[] nums ={0,1,0,3,12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
       int z=0, nz=0;
       while(nz < nums.length){
           if(nums[nz]!=0){
               int tmp = nums[z];
               nums[z] = nums[nz];
               nums[nz] = tmp;
               z++;
               nz++;
           }else{
               nz++;
           }
       }
        System.out.println(Arrays.toString(nums));

    }
}
