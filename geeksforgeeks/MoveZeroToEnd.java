package geeksforgeeks;

import java.util.Arrays;

public class MoveZeroToEnd
{
    public static void main ( String[] args ){
        int [] nums = {0, 1 , 0, 3 , 12, 9, 7, 0 , 0, 0};
//        int [] nums = {1, 0, 1};
//            moveZeroToEnd(nums);
        twoPinterApproach(nums);

    }
    public static void moveZeroToEnd(int[] nums){
        int [] nums2 = new int[nums.length];
        int j =0;
        int count = 0;
        for ( int i=0; i <= nums.length -1; i++){
            if(nums[i] != 0){
                nums2[j++] = nums[i];
            }else{
                count ++;
            }
        }
        System.out.println(Arrays.toString(nums2));
        System.out.println(count);
        System.arraycopy(nums2, 0, nums, 0, nums.length);

        System.out.println(Arrays.toString(nums));


        for (int k= count; k > 0; k-- ){
            nums[ nums.length - k] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

//    public static void twoPinterApproach( int[] nums ){
//        int p1 = 0;
//        int p2 = 1;
//        int count = 0;
//        System.out.println(nums.length);
//        while ( p2 < nums.length ){
//            if(nums[p1] == 0 ){
//                count ++;
//            }
//            if(count > 0){
//                if(nums[p2] !=0 ){
//                    nums[p1] = nums[p2];
//
//                    p1++;
//                    p2++;
//                }else{
//                    count++;
//                    p2 = p2+1;
//                }
//
//            }
//
//        }
//        System.out.println(count);
//        while(count < nums.length-1 ){
//            nums[count+1] = 0;
//            count ++;
//        }
//
//
//        System.out.println(Arrays.toString(nums));
//    }
public static void twoPinterApproach( int[] nums ){
    int p1 = 0; // Pointer for the position of the last non-zero found
    int p2 = 0; // Pointer for scanning the array

    while (p2 < nums.length) {
        // If we find a non-zero at p2
        if (nums[p2] != 0) {
            // Swap if p1 and p2 are not the same
            if (p1 != p2) {
                nums[p1] = nums[p2];
                nums[p2] = 0;
            }
            p1++; // Move the position of the last non-zero found
        }
        p2++; // Always move the p2 pointer
    }

    System.out.println(Arrays.toString(nums));
}
    public void moveZeroes(int[] nums) {
        int z=0, nz=0;
        while(nz < nums.length){
            if(nums[nz] !=0 ){
                int tmp= nums[nz];
                nums[nz] = nums[z];
                nums[z]=tmp;
                nz++;
                z++;
            }else{
                nz++;
            }
        }
    }
}
