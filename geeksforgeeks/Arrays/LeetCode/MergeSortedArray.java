package geeksforgeeks.Arrays.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray
{
    public static void main (String[] args){
        int[] nums1 = {4,5,6,0,0,0};
        int m =3, n=3;
        int []  nums2 = {1,2,3};
        merge(nums1, m, nums2, n);

    }
    public static void  merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1, p2 =n-1, p = m+n-1;
        while (p1>=0 && p2>=0){
            if(nums1[p1] > nums2[p2]){
                nums1[p--] = nums1[p1--];
            }else{
                nums1[p--] = nums2[p2--];
            }
        }
        while(p2>=0){
            nums1[p--] = nums2[p2--];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
