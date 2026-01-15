package geeksforgeeks.Arrays;

public class FirstMisssingPositive
{
    public static void main(String[] args)
    {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositiveUsingSpace(nums));
        System.out.println(firstMissingPositiveWithoutUsingSpace(nums));
    }

    public static int firstMissingPositiveUsingSpace(int[] nums) {
        int[] dummyNums = new int[nums.length];
        for(int i=0; i< nums.length; i++){
            if(nums[i] <= nums.length){
                int index = nums[i] -1;
                if(nums[i] > 0){
                    dummyNums[index] = nums[i];
                }
            }

        }
        for(int i=0; i< dummyNums.length; i++){
            if(dummyNums[i] == 0){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static int firstMissingPositiveWithoutUsingSpace(int[] nums) {
        for(int i=0; i< nums.length; i++){
            while(nums[i] >0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                int index = nums[i] - 1;
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        for(int i=0; i< nums.length; i++){
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length+1;
    }
}
