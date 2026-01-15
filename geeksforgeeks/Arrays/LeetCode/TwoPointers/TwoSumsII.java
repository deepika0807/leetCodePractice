package geeksforgeeks.Arrays.LeetCode.TwoPointers;

import java.util.Arrays;

public class TwoSumsII
{
    public static void main ( String args[] ){
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
            int[] response = new int[2];
            int p1 = 0, p2 = numbers.length-1;
            while ( p1 <= p2 ){
                if ( numbers[p1] + numbers[p2] < target ){
                    p1++;
                }else if (numbers[p1] + numbers[p2] > target  ){
                    p2--;
                }else{
                    response[0] = p1+1;
                    response[1] = p2+1;
//                    return new int[]{p1 + 1, p2 + 1};
                    break;
                }
            }
//        return new int[]{-1, -1};
        return response;
    }
}
