package Interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test5
{
    public static void main(String[] args)
    {
        String str = "catsandog";
        Set<String> dict = new HashSet();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");
        int end = str.length()-1;
        System.out.println(checkForExistence(str, dict, end));
    }

    static boolean checkForExistence(String str, Set dict, int end)
    {
        if (str.length() == end)
        {
            return true;
        }

        for (int i = 0; i < str.length(); i++)
        {
            String search = "";
            if (dict.contains(search + str.charAt(i)))
            {
                return checkForExistence(str.substring(str.charAt(i + 1), str.length()), dict, end);
            }
        };
        return false;
    }

}
