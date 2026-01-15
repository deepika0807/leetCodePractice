package geeksforgeeks.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//A leader is an element that is greater than or equal to all the elements to its right.
public class ArrayLeaders
{
    public static void main(String[] args){
       int[] arr = {10, 4, 2, 4, 1};
        ArrayList<Integer> response = leaders(arr);
        System.out.println(Arrays.toString(response.toArray()));
    }

//    Brute Force Solution
//    static ArrayList<Integer> leaders(int arr[]) {
//        ArrayList<Integer> response = new ArrayList<Integer>();
//        for ( int i=0; i < arr.length; i++ ){
//            int index = arr[i], count=0;
//            for ( int j= i+1; j < arr.length; j++ ){
//                if( arr[j] > index ){
//                    count ++;
//                }
//            }
//            if ( count == 0 ){
//                response.add(index);
//            }
//        }
//        return response;
//    }

//    Optimised Solution
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> response = new ArrayList<Integer>();
        int leader = Integer.MIN_VALUE;
        for ( int index = arr.length-1; index >= 0; index -- ){
            if ( arr[index] >= leader ){
                response.add(arr[index]);
                leader = arr[index];
            }
        }
        Collections.reverse(response);
        return response;
    }


}
