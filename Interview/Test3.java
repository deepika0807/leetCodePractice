package Interview;

import java.util.HashMap;

public class Test3
{
    public static void main(String[] args)
    {
        String str = "abcabcbb";
        int maxLength = 0;
        HashMap<Character, Integer> freqMap= new HashMap<>();
        int count =0;
        for(int i=0; i<str.length(); i++){
            if(freqMap.containsKey(str.charAt(i)) ){
                maxLength = Math.max(maxLength, count);
                freqMap = new HashMap<>();
                freqMap.put(str.charAt(i), 1);
                count = 1;
            }else{
                count++;
                freqMap.put(str.charAt(i), 1);
            }
        }
        System.out.println(maxLength);

    }


}
