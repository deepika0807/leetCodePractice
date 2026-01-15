import java.util.Arrays;
import java.util.stream.Collectors;

public class CommonLongestPrefix
{
    public static void main ( String args[] ){
        String[] strs = new String[] {"reflower","flow","flight"};
        longestCommonPrefix(strs);
    }

    public static void longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String result = "";
        for ( int index =0; index <= strs[0].length() -1 ; index ++ ){
            System.out.println("strs[0].charAt(index)" + strs[1]);
//            Check 1st and last element of an array.
            if( strs[0].charAt(index) == strs [strs.length -1].charAt(index)){
                result = result+ strs[0].charAt(index);

            }else{
                break;
            }
        }
        System.out.println(result);
    }
}
