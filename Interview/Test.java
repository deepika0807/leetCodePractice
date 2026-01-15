package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test
{
    public static void main (String[] args){
        testFunc();
    }

    public static void  testFunc ()
    {
//        String s ="aabbbcddeee";
//        Map<Character, Long> freqMap = new LinkedHashMap<>();
//        freqMap = s.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c-> c, LinkedHashMap::new, Collectors.counting()));
//        Character response = freqMap.entrySet().stream().filter(c-> c.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
//        System.out.println(response);
        int[] arr1 = {5, 3, 2, 7, 1};
        Set<String> response = new HashSet<>();
        int k = 2;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {  // start from i+1
                if (Math.abs(arr1[i] - arr1[j]) == k) {
                    String pair = "(" + arr1[i] + "," + arr1[j] + ")";
                    if (!response.contains(pair)) {
                        response.add(pair);
                        System.out.println(pair);
                    }
                }
            }
        }

    }
}
