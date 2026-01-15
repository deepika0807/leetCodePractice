import java.util.HashMap;
import java.util.Map;

public class RomanNumbers
{

    public static void main(String args[])
    {
        int number = 324;
        String roman = "CCCXXIV";
        intToRoman(324);
        romainToInt(roman);
    }
//    ASk Interviewer that how many digits maximum we will consider
    public static void intToRoman(int number)
    {
        String[] thousands = new String[] { "", "M", "MM", "MMM" };
        String[] hundreds = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] units = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        String result = thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number
                % 10];
        System.out.println(result);
    }

    public static void romainToInt(String roman){
        int result = 0;
        Map<Character, Integer> map = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        for (int i=0; i<roman.length(); i++ ){

            if( i>0 &&  map.get(roman.charAt(i)) >  map.get(roman.charAt(i -1))){
                result = result -  map.get(roman.charAt(i -1));
                result = result +  map.get(roman.charAt(i)) - map.get(roman.charAt(i -1)) ;
            }else{
                result +=  map.get(roman.charAt(i));
            }

        }

        System.out.println(result);

    }
}
