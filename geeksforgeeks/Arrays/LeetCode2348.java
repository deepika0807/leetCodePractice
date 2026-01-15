package geeksforgeeks.Arrays;

public class LeetCode2348
{
    public static void main(String[] args)
    {
        int[] nums = {0,0,0,2,0,0};
        System.out.println(zeroFilledSubarray(nums));
    }
//    public static long zeroFilledSubarray(int[] nums) {
//        int count = 0;
//        if(nums[0] == 0){
//            count++;
//        }
//        for ( int i=1; i< nums.length; i++){
//            if(nums[i]== 0){
//                count++;
//            }else if(nums[i-1] == 0){
//                count++;
//            }
//
//        }
//        if(nums[nums.length-1] == 0){
//            count++;
//        }
//        return count;
//    }

    public static long zeroFilledSubarray(int[] nums) {
        int res = 0, count=0;
        for( int i=0; i< nums.length; i++){
            if(nums[i]==0){
                count = count+1;
            }else{
               count =0;
            }
            res = res+count;
        }
        return  res;
    }
}
