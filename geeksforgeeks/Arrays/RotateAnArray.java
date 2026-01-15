package geeksforgeeks.Arrays;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// The rotation (Anti-clockwise) should be right rotation that's why the order of rotation should be the following
public class RotateAnArray implements Serializable
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, "DummyValue");
        hashMap.put(0, "DummyValue2");
        System.out.println(hashMap);
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate(nums, k);
    }
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k<0){
            k = k + nums.length;
        }

        swap(nums, 0, nums.length-1);    // reverse entire array
        swap(nums, 0, k-1);              // reverse first k
        swap(nums, k, nums.length-1);    // reverse remaining
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] nums, int start, int end) {
        while(start < end){
            int swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;
            start++;
            end--;
        }
    }

}
