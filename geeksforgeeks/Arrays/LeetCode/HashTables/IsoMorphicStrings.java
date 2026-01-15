package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.HashMap;
import java.util.Map;

/***
 return false;
 * Arrays → property (length)
 *
 * Strings → method (length())
 *
 * Collections (ArrayList, etc.) → method (size())
 */
public class IsoMorphicStrings
{
    public static void main(String[] args)
    {
        String s="badc", t="kikp";
        System.out.println(isIsomorphic(s, t));

    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> freqMap = new HashMap<>();
        Integer[] value = new Integer[5];
        if(s.length() != t.length()){
            return false;
        }
        for( int i=0; i< s.length(); i++){
            Character original = s.charAt(i);
            Character replacement = t.charAt(i);
            if(!freqMap.containsKey(original)) {
                if(!freqMap.containsValue(replacement)){
                    freqMap.put(original, replacement);
                }else{
                    return false;
                }
            }else{
                if(freqMap.get(original) != replacement){
                    return false;
                }
            }
        }
        return true;
    }
}
