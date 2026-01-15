package Interview;

import java.io.Serializable;
import java.util.Arrays;

public class Test2
{

    public static void main(String[] args)
    {
        int [] arr =  {1,2,3,4,5,6,7,8,9,10};
        int k=4;
        testFunc(arr, k) ;
    }
    public static void  testFunc (int[] arr, int k)
    {
        int i=0;
        int j=1;
        int end =(j*k)-1;
        while(i< arr.length){
            if(end > arr.length){
                end = arr.length -1;
            }
            swap(arr, i, end);
            i=i+k;
            j++;
            end =(j*k)-1;
        }

        System.out.println(Arrays.toString(arr));

    }
    public static void  swap (int[] arr, int start, int end)
    {
        while(start < end){
            int value = arr[start];
            arr[start] = arr[end];
            arr[end] = value;
            start++;
            end --;
        }

    }
}
