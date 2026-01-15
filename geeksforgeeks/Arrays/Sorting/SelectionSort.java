package geeksforgeeks.Arrays.Sorting;

import java.util.Arrays;
//  Use Bubble Sort: If stability matters or array may already be nearly sorted
//
//  Use Selection Sort: If writes/swaps are expensive (e.g., flash memory)
public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] nums = {1, 4, 5, 2,};
        selectionSort(nums);
    }
    static void selectionSort(int[] nums){
        for(int i=0; i< nums.length-1; i++){
            int compare = nums[i];
            int index = i;
            for(int j = i+1; j<nums.length; j++){
                if(nums[j] < compare){
                    compare = nums[j];
                    index = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
