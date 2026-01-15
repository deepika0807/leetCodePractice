package geeksforgeeks.Arrays.Sorting;

import java.util.Arrays;
//  Use Bubble Sort: If stability matters or array may already be nearly sorted
//
//  Use Selection Sort: If writes/swaps are expensive (e.g., flash memory)
public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] arr = {1, 4, 5, 2,};
        bubbleSort(arr);
    }

    static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length - (i+1) ; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
