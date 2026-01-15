package geeksforgeeks.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayDuplicates
{
    public static void main ( String[] args ){
        int[] arr = {2, 3, 1, 2, 3};
        System.out.println(Arrays.toString(findDuplicates(arr).toArray()));
        System.out.println(Arrays.toString(findDuplicatesOptimisedWithSpace(arr).toArray()));
        System.out.println(Arrays.toString(findDuplicatesOptimised(arr).toArray()));
    }

//    Brute Force
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> elem=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                elem.add(arr[i]);
            }
        }
        return elem;
    }

    //    Optimised Solution
    public static ArrayList<Integer> findDuplicatesOptimisedWithSpace(int[] arr) {
        ArrayList<Integer> elem=new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int ele : arr){
            if(!set.add(ele)){
                elem.add(ele);
            }
        }
        return elem;
    }

    public static ArrayList<Integer> findDuplicatesOptimised(int[] arr){
        ArrayList<Integer> elem=new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                // already visited once → duplicate found
                elem.add(index + 1);
            } else {
                // mark it as visited
                arr[index] = -arr[index];
            }
        }

        return elem;
    }

    /***
     * Java arrays don’t have .stream() directly — that’s why the compiler is yelling at you like:
     *
     * cannot find symbol: method stream() on int[]
     *
     * Because primitive arrays (int[]) don’t expose .stream().
     * You must use Arrays.stream(nums) instead.
     *
     * Why .boxed()?
     *
     * Because Arrays.stream(nums) gives you an IntStream,
     * but groupingBy works with objects, not primitives — so we convert int → Integer.
     *
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicatesStreams(int[] nums) {
        Map<Integer, Long> map =  Arrays.stream(nums).boxed().collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        List<Integer> res =  map.entrySet().stream().filter(c-> c.getValue() > 1).map(Map.Entry:: getKey).collect(Collectors.toList());
        return res;
    }

}
