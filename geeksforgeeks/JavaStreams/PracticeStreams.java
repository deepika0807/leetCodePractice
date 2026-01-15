package geeksforgeeks.JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.jdi.connect.spi.TransportService;

/***
 * First, one crystal-clear idea 💡
 *
 * 👉 filter decides WHO stays
 * 👉 map decides WHAT they become
 *
 * That’s it. Everything else is decoration.
 *
 * Think in human terms (not Java yet)
 *
 * Imagine a college fest entry gate:
 *
 * 🛂 filter
 *
 * The security guard checks:
 *
 * “Only students with ID cards can enter.”
 *
 * ❌ No ID → thrown out
 * ✅ ID → allowed in
 *
 * That’s filter.
 *
 * 🎭 map
 *
 * Inside the fest, organizers say:
 *
 * “Convert every student into a participant badge.”
 *
 * Same people, different form.
 *
 * That’s map.
 *
 * Now translate to Java Streams 🧠
 * filter
 *
 * Input type = Output type
 *
 * Removes elements
 *
 * Condition based
 *
 * .filter(x -> condition)
 *
 *
 * Ask yourself:
 *
 * “Am I rejecting some elements?”
 *
 * If yes → filter.
 *
 * map
 *
 * Input type can change
 *
 * Transforms elements
 *
 * One-to-one conversion
 *
 * .map(x -> transformedValue)
 *
 *
 * Ask yourself:
 *
 * “Am I changing the shape/value of each element?”
 *
 * If yes → map.
 */
public class PracticeStreams
{
    public static void main(String[] args)
    {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        System.out.println(sumOfNumbers(list));
//        System.out.println(averageOfNumber(list));
//        System.out.println(numberSquareAverage(list));
//        System.out.println(evenNumber(list));
//        System.out.println(oddNumber(list));
//        System.out.println(maxNumber(list));
//        LimitNumbers(list);
//        SecondLowestHighestNumber(list);
//        FirstNonRepeatingChar();
//        CountFreqOfChar();
//        FindAllDupCharacters();
//        RemoveDuplicateAndRemoveOrder();
//        ReverseEachWord();
//        LongestWordInSentence();
        LongestWordInSentenceII();
    }

    public static int sumOfNumbers(List<Integer> list)
    {
        return list.stream().reduce(0, (a, b) -> a + b);
    }

    public static int averageOfNumber(List<Integer> list)
    {



        return (list.stream().reduce(0, (a, b) -> a + b)) / (list.size());
        //        return list.stream()
        //                .mapToInt(Integer::intValue)
        //                .average()
        //                .orElse(0.0); // handles empty list
    }

    public static int numberSquareAverage(List<Integer> list)
    {
        return (list.stream().map(num -> num * num).reduce(0, (a, b) -> a + b)) / list.size();
    }

    public static List<Integer> evenNumber(List<Integer> list){
        return list.stream().filter(num-> num%2 ==0).collect(Collectors.toList());
    }

    public static List<Integer> oddNumber(List<Integer> list){
        return list.stream().filter(num-> num%2 !=0).collect(Collectors.toList());
    }

    public static List<Integer> numberStartsWith (List<Integer> list){
//        return list.stream()
//                .filter(num -> firstDigit(num) == 2)
//                .toList();

        return list.stream().filter(num -> String.valueOf(num).startsWith("2")).collect(Collectors.toList());
    }

//    private static int firstDigit(int num) {
//        num = Math.abs(num); // handle negatives
//        while (num >= 10) {
//            num /= 10;
//        }
//        return num;
//    }

    public static Set<Integer> duplicateNumbers(List<Integer> list ){
//        return list.stream().filter(a-> Collections.frequency(list, a) > 1).collect(Collectors.toSet());

        Set<Integer> duplicateSet = new HashSet<>();
        return list.stream().filter(num -> !duplicateSet.add(num)).collect(Collectors.toSet());

    }

    public static int maxNumber ( List<Integer> list){
//        return list.stream()
//                .max(Integer::compareTo) // returns Optional<Integer>
//                .orElseThrow(() -> new NoSuchElementException("List is empty"));

        return list.stream()
                .max((a, b) -> a.compareTo(b))
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static int minNumber ( List<Integer> list){
      return list.stream().min(Integer:: compareTo).orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static List<Integer> sorted(List<Integer> list){
       return list.stream().sorted().collect(Collectors.toList());
    }
    public static List<Integer> sortedDesc(){
        List<Integer> list = Arrays.asList(1,3,6,3,1,7);
       return list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static void LimitNumbers(List<Integer> list){
        int limitValue = list.stream().limit(5).reduce(0,(a,b)-> a+b);
        int skipValue = list.stream().skip(5).reduce(0,(a,b)-> a+b);
        System.out.println("limitValue"+ limitValue);
        System.out.println("limitValue"+ skipValue);

    }

    public static void SecondLowestHighestNumber(List<Integer> list){
        int secHighest = list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
        int secLowest = list.stream().sorted().skip(1).findFirst().get();
        System.out.println("secHighest"+ secHighest);
        System.out.println("secLowest"+ secLowest);
    }

    public static void FirstNonRepeatingChar(){
        String str = "swiss";
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for ( char c: str.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
//        freqMap = str.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c-> c, LinkedHashMap::new, Collectors.counting()));
//
        Character response = freqMap.entrySet().stream().filter(c -> c.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(response);
    }

    //     Count Frequency of each character
    public static void CountFreqOfChar(){
            String str = "swiss";
            Map<Character, Long> freqMap =  str.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        System.out.println(freqMap);
    }

    //Find All Duplicate Characters
    public static void FindAllDupCharacters(){
        String str = "swissppee";
        Map<Character, Long> freqMap =  str.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        List<Character> freqList = freqMap.entrySet().stream().filter(c-> c.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(freqList);
    }

//    Remove Duplicates and Keep Order
    public static void RemoveDuplicateAndKeepOrder(){
        String str = "swissppee";
        System.out.println( str.chars().mapToObj(c ->  String.valueOf((char)c)).distinct().collect(Collectors.joining()));

    }

//     Reverse each word in sentence
    public static void ReverseEachWord(){
    String sentence = "Java Streams Interview";
    String reversedSentence = Arrays.stream(sentence.split(" ")).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
    System.out.println(reversedSentence);

}

// Find Longest Word in a Sentence
public static void LongestWordInSentence(){
    String sentence = "Accolite likes Java interviews";
    String longest  =Arrays.stream(sentence.split(" ")).max((a,b)-> Integer.compare(a.length(), b.length()) ).orElse(null);
//    String longest = Arrays.stream(sentence.split(" ")).max(Comparator.comparingInt(String::length)).orElse("");
    System.out.println(longest);

}
    public static void LongestWordInSentenceII(){
        String sentence = "Accolite likes Java interviews";
        Map<String, Integer>  response = (Arrays.stream(sentence.split(" "))).collect(Collectors.toMap(word -> word, String::length)).entrySet().stream()
                .max((a, b) -> Integer.compare(a.getValue(), b.getValue())).map(entry -> Map.of(entry.getKey(), entry.getValue())) .orElse(Map.of());        // convert to Map<String,Integer>
        ;
        System.out.println(response);

    }
    public static void  GroupByOnFirstChar (){
        List<String> names = Arrays.asList("Amit", "Deepa", "Rahul", "Akhil");

        //        List<String>  ResponeA= names.stream().filter((value) -> value.startsWith("A")).collect(Collectors.toList());
        //        List<String>  ReposeB =  names.stream().filter((value) ->value.startsWith("D")).collect(Collectors.toList());
        //        List<String>  ReposeC =  names.stream().filter((value) -> value.startsWith("R")).collect(Collectors.toList());
        //        System.out.println("A: " + ResponeA  + "B:" + ReposeB + "C:" + ReposeC);
        Map<Character, List<String>> freqMap = names.stream().collect(Collectors.groupingBy(name-> name.charAt(0)));
        System.out.println(freqMap);
    }

//    Leetcode 442
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Long> map =  Arrays.stream(nums).boxed().collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        List<Integer> res =  map.entrySet().stream().filter(c-> c.getValue() > 1).map(Map.Entry:: getKey).collect(Collectors.toList());
        return res;
    }


}
