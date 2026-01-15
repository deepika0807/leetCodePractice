package geeksforgeeks;

public class RemoveDuplicatedFromSortedArray
{
    public static void main (String args[])
    {
//        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[] {1,1,2};
        int result = removeDuplicates(nums);
        System.out.println(result);


    }

    public static int removeDuplicates(int[] nums) {
        int p1=0;
        int p2=1;
        while(p2 < nums.length){
            if(nums[p1] == nums[p2]){
                p2++;
            }else{
                p1++;
                nums[p1] = nums[p2];
                p2++;
            }
        }
        return p1+1;
    }

}
