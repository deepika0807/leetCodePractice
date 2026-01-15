package Interview;

import java.util.HashMap;
import java.util.Map;

public class Test6
{
    public static void main(String[] args)
    {
        Map<Integer, String> map1 = new HashMap<>();

        map1.put(101, "Rahul");

        map1.put(103, "Raj");

        map1.put(106, "Chinna");

        map1.put(105, "Rahim");

        Map<String, Double> map2 = new HashMap<>();

        map2.put("Chinna", 50000.0);

        map2.put("Rahim", 60000.0);

        map2.put("Raj", 70000.0);

        map2.put("Rahul", 20000.0);
        map2.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    String name = entry.getKey();
                    Double salary = entry.getValue();

                    Integer id = map1.entrySet().stream()
                            .filter(e -> name.equals(e.getValue()))
                            .findFirst()
                            .map(Map.Entry::getKey)
                            .orElse(null);

                    System.out.println(id + "," + salary);
                });
        //        map2.entrySet().stream()
        //                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
        //                .forEach(entry -> {
        //                    String name = entry.getKey();
        //                    Double salary = entry.getValue();
        //
        //                    // find matching ID from map1
        //                    Integer id = map1.entrySet().stream()
        //                            .filter(e -> e.getValue().equals(name))
        //                            .map(Map.Entry::getKey)
        //                            .findFirst()
        //                            .orElse(null);
        //
        //                    System.out.println(id + "," + salary);
        //                });

    }
}
