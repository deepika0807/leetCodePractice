package geeksforgeeks.Arrays.LeetCode.Recursion.Patterns;

import java.util.Arrays;

/***
 * Two quick points:
 *
 * For merging two arrays of sizes n and m, the merge step is O(n + m). ✅
 *
 * For merge sort on a single array of length N, the standard result is O(N log N).
 *
 * Here’s the clean derivation (short and sharp):
 *
 * At each level of recursion you do a merge of every subarray — across the whole level you process all N elements once, so the work per level is O(N) (same idea as your n + m but summed across subproblems).
 *
 * How many levels? You repeatedly split by 2 until size 1 → about log₂N levels.
 *
 * Multiply: O(N) × O(log N) = O(N log N).
 *
 * Recurrence form (if you like formulas):
 *
 * T(N) = 2 T(N/2) + O(N)
 *
 *
 * Solve with Master Theorem → T(N) = O(N log N).
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = {1 ,5 ,6, 3, 8};
        System.out.println(Arrays.toString(mergeSort(arr)));

        mergeSortInPlace(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    static int[] mergeSort(int arr[]){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
//        int[] leftArray = mergeSort(Arrays.copyOfRange(arr, 0, mid));
//        int[] rightArray = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        int[] leftArray = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(leftArray, rightArray);
    }

    static int[] merge(int[] leftArray, int[] rightArray){
        int size = leftArray.length + rightArray.length;
        int[] mix = new int[size];
        int i=0, j=0, k=0;
        while(i< leftArray.length && j< rightArray.length){
            if(leftArray[i] < rightArray[j]){
                mix[k++] = leftArray[i++];
            }else{
                mix[k++] = rightArray[j++];
            }
        }

        while(i < leftArray.length){
            mix[k++] = leftArray[i++];
        }

        while(j< rightArray.length){
            mix[k++] = rightArray[j++];
        }
        return mix;
    }



    static void mergeSortInPlace(int[] arr, int start, int end) {
        if (start >= end) {
            return;   // base case
        }

        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid + 1, end);

        mergeInPlace(arr, start, mid, end);
    }

    static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;     // left half pointer
        int j = mid + 1;   // right half pointer
        int k = 0;         // temp array pointer

        // Merge both halves
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }
}
