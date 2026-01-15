package geeksforgeeks;

import java.util.Arrays;

public class RotateArray
{
    public static void main (String args[])
    {
        int[] nums = new int[] {1,2,3,4,5,6,7};
//        int[] nums = new int[]{-1,-100,3,99};
        int k=3;
        rotate(nums, k);
    }

    /***
     *
     First Solution but time complexity is O(n*k)
     */
    //    public static void rotate(int[] nums, int k)
//    {
//       while (k > 0 ){
//           int lastEle = nums[nums.length - 1];
//           for( int ele=nums.length-1; ele > 0 ; ele -- ){
//               nums[ele] = nums[ele -1] ;
//           }
//           nums[0] = lastEle;
//           k--;
//       } System.out.println(Arrays.toString(nums));
//    }

    /***
     * This will not work because k can be greater than length of an Array
     */
    //    public static void rotate(int[] nums, int k)
//    {
//        int p1= k-1;
//        int p2= nums.length -1;
//        int num1 = nums[p1];
//        int num2 = nums[p2];
//        if(nums.length %2 != 0 && p1 >= 0){
//            nums[p2] = nums[k];
//            while (p1 > 0){
//                p2--;
//                num1 = nums[p1];
//                nums[p1] = num2;
//                num2 = nums[p2];
//                nums[p2] = num1;
//                p1--;
//            }
//            int num3 = nums[0];
//            nums[p2] = num1;
//            nums[p1] = num2;
//            nums[--p2] = num3;
//    }else{
//            while (p1 >0){
//                nums[p2] = num1;
//                nums[p1] = num2;
//                p1--;
//                p2--;
//                num1 = nums[p1];
//                num2 = nums[p2];
//
//            }
//            nums[p2] = num1;
//            nums[p1] = num2;
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }


//https://www.youtube.com/watch?v=oABQlhrhXzg
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

}
