package geeksforgeeks.Arrays;

public class IncreasingTripletSubsequence
{
    public static void main(String[] args)
    {
       int[] nums = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));
    }

//    public static boolean increasingTriplet(int[] nums) {
//        int p1 =0, p2=2;
//        while(p2 < nums.length){
//            if((nums[p1] < nums[p1+1]) && (nums[p1]< nums[p2]) && (nums[p1+1] < nums[p2]) ){
//                return true;
//            }else{
//                p1++;
//                p2++;
//            }
//        }
//        return false;
//    }

//    Greedy Algorithm
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                // Found a number greater than both first and second
                return true;
            }
        }
        return false;
    }
}
