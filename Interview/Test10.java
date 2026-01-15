package Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test10
{
    public static void main(String[] args)
    {
//        String str1 ="racecar";
//        String str2 ="carrace";
//        System.out.println(checkAnagram(str1, str2));
        int[] arr ={1, 2, 3, 4};
        System.out.println(checkValueDuplicate(arr));

    }

    static boolean checkAnagram(String str1,  String str2){
        int[] freq = new int[26];
        int[] freqStr2 = new int[26];
        for(int i=0; i< str1.length(); i++){
            freq[str1.charAt(i) - 'a'] ++;
        }
        for(int i=0; i< str2.length(); i++){
            freqStr2[str2.charAt(i) - 'a'] ++;
        }

        for(int i=0; i<freq.length; i++){
            if(freq[i] != freqStr2[i]){
                return false;
            }
        }
        return true;
    }
    static boolean checkValueDuplicate(int[] arr){
        Set<Integer>  integerSet = new HashSet<>();
        for(int i=0; i< arr.length; i++){
            if(!integerSet.add(arr[i])){
               return false;
            }
        }
        return true;
    }

}
