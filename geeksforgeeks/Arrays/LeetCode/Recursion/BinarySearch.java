package geeksforgeeks.Arrays.LeetCode.Recursion;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] nums={1, 2, 3, 4, 5};
        int target = 6;
        System.out.println(binarySearch(nums, 0, nums.length-1,target ));
    }

    static boolean binarySearch(int[] nums, int start, int end, int target){
        if(start > end){
            return false;
        }
        int middle = start + (end-start) /2;
       if(nums[middle] > target ){
            end = middle -1;
        }else if(nums[middle] < target){
            start = middle+1;
        }else{
           return true;
        }
           return binarySearch(nums, start, end, target);
    }

}
