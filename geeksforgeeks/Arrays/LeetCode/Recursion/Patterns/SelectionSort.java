package geeksforgeeks.Arrays.LeetCode.Recursion.Patterns;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] arr = {2, 1, 3, 5, 0};
        selectionSort(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr, int n){
        if(n < 0){
            return;
        }
        int maxIndex = innerSort(arr, 0, n, 0);
        int tmp = arr[n];
        arr[n] = arr[maxIndex];
        arr[maxIndex] = tmp;
        selectionSort(arr, n-1);
    }
    static int innerSort(int[] arr, int start, int end, int maxIndex){
        if(start > end){
            return maxIndex;
        }
            if(arr[start] > arr[maxIndex]){
                maxIndex = start;
            }


       return innerSort(arr, start+1, end ,maxIndex);

    }
}
