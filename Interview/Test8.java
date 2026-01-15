package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Test8
{
    public static void main(String[] args)
    {
        String str ="Keep calm and code on ";
        System.out.println(arrangeWords(str));
    }

    public static String arrangeWords(String text){
        String lower = text.toLowerCase();

        // Step 2: split and sort based on word length
        String sorted = Arrays.stream(lower.split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.joining(" "));

        // Step 3: capitalize first character of final string
        return sorted.substring(0, 1).toUpperCase() + sorted.substring(1);

    }
}
