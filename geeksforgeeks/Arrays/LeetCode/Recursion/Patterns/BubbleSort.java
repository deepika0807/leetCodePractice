package geeksforgeeks.Arrays.LeetCode.Recursion.Patterns;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] arr = {2, 1, 3, 5, 0};
        System.out.println(Arrays.toString(bubbleSort(arr, arr.length, arr.length)));
        bubbleSort(arr, arr.length);
    }

    static int[] bubbleSort(int[] arr, int r, int c){
        if(r==0){
            return arr;
        }
        if(c<r){
            if(arr[c] > arr[c+1]){
                int tmp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = tmp;
            }
            return bubbleSort(arr, r, c+1);
        }else{
            return bubbleSort(arr, r-1, 0);
        }
    }

    static void bubbleSort(int[] arr, int n) {
        if (n == 1) return;

        innerBubble(arr, 0, n);

        bubbleSort(arr, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void innerBubble(int[] arr, int i, int n) {
        if (i == n - 1) return;

        if (arr[i] > arr[i + 1]) {
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }

        innerBubble(arr, i + 1, n);
    }

}
