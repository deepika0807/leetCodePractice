package geeksforgeeks.Arrays.LeetCode.Recursion;

public class CheckSortedArray
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 0};
        System.out.println(checkForSortedArray(nums, 0, 1));
    }

    static boolean checkForSortedArray(int[] nums, int first, int second){
        if(second > nums.length-1){
            return true;
        }

        if(nums[first] > nums[second]){
            return false;
        }
        return checkForSortedArray(nums, ++first, ++second);
    }
}
