package geeksforgeeks.Arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=l65QqDWD6xk
//Moore’s Voting Algorithm (
// Majority element appears more than n/2 times.
//
//If you “cancel out” each occurrence of the majority element with a different element, the majority element will still survive at the end.
// )

public class MajorityElement
{
    public static void main(String[] args)
    {
        int[] num = {2,2,1,1,1,2,2};
        majorityElementStreams(num);
        System.out.println(majorityElement(num));
    }

    public static void majorityElementStreams(int[] nums) {
        Map<Integer, Long> freqMap=  Arrays.stream(nums).mapToObj(a-> (Integer) a).collect(Collectors.groupingBy(a-> a, Collectors.counting()));
        int value = freqMap.entrySet().stream().filter(a-> a.getValue() > nums.length/2).map(Map.Entry::getKey).findFirst().orElseThrow();;
        System.out.println(value);
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int i=0; i< nums.length; i++){
           if(nums[i] == candidate){
               count++;
           }else{
               count --;
           }
           if(count == 0){
               candidate = nums[i];
               count++;
           }
        }
        return candidate;
    }
}
