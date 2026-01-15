package geeksforgeeks.Arrays;

//https://www.youtube.com/watch?v=G-EWVGCcL_w

public class NumberOfZeroFilledSubArrays
{
    public static void main(String[] args)
    {
        int[] nums ={1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(nums));
    }

    /***    Every 0 is adding as another subarray
     * [0] -> 1 Subarray
     * [0,0] -> [0][0] -> 2Subarray 1+2 = 3
     * @param nums
     * @return
     */
    public static long zeroFilledSubarray(int[] nums) {
        int count=0;
        long response=0;
        for ( int i=0; i<nums.length; i++){
            if(nums[i] == 0 ){
                count++;
                response = response + count;
            }else{
                count = 0;
            }
        }
        return response;
    }

    public static long zeroFilledSubarrayApproach2(int[] nums) {
        long result = 0;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] == 0) {
                int length = 0;
                while (i < n && nums[i] == 0) {
                    length++;
                    i++;
                }
                result += (long) length * (length + 1) / 2;
            } else {
                i++;
            }
        }
        return result;
    }

}
