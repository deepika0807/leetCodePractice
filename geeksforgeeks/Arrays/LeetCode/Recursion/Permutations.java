package geeksforgeeks.Arrays.LeetCode.Recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=vKQ6oUH02gw
public class Permutations
{
    public static void main(String[] args)
    {
        String[] str = {"a", "a", "c"};
        permutaion(str, 0);
    }
    static void permutaion(String[] str, int fi){
        if(fi == str.length-1){
            System.out.println(Arrays.toString(str));
            return;
        }
        // 👉 Set to avoid duplicates at this level
        Set<String> used = new HashSet<>();
        for(int i= fi; i< str.length; i++){
            // 👉 skip duplicate choice at the same index
            if (used.contains(str[i])) continue;
            used.add(str[i]);

            swap(str, i, fi);
            permutaion(str, fi+1);
            swap(str, i, fi);
        }
    }

    static void swap(String[] str, int i, int fi){
        String tmp = str[i];
        str[i] = str[fi];
        str[fi] = tmp;
    }
}
