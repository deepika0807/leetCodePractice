package geeksforgeeks.Arrays.LeetCode.Recursion;

import java.util.ArrayList;

public class FindAllIndexes
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 3 ,4};

        System.out.println(findAllIndexes(arr, 3, 0));
    }

    static ArrayList<Integer> findAllIndexes(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if( index == arr.length){
            return list;
        }
//        This wil contain answer for that function call only
        if(arr[index] == target){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndexes(arr, target, ++index);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
