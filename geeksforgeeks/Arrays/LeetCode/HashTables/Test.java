package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.Arrays;

public class Test
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4};
        int tmp = arr[0];
        for ( int i=1; i< arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = tmp;
        System.out.println(Arrays.toString(arr));
    }
}
