package geeksforgeeks.Arrays.LeetCode.Recursion.SubSeq;

import java.util.ArrayList;

public class SubSeqAsciReturn
{
    public static void main(String[] args)
    {
        System.out.println(subSeqAsciiRet("", "abc"));
    }
    static ArrayList<String> subSeqAsciiRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first =subSeqAsciiRet(p+ch, up.substring(1));
        ArrayList<String> sec =subSeqAsciiRet(p, up.substring(1));
        ArrayList<String> third =subSeqAsciiRet(p + (ch + 0), up.substring(1));
        first.addAll(sec);
        first.addAll(third);
        return first;

    }
}
