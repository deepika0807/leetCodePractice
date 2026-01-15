package geeksforgeeks.Arrays.LeetCode.Recursion;

public class CountZeroes
{
    public static void main(String[] args)
    {
        System.out.println(countZeroes(120567023, 0));
    }
    static int countZeroes(int num, int count){
        if(num == 0){
          return count;
        }

        if(num%10 == 0) return countZeroes(num/10, ++count);
        return countZeroes(num/10, count);
    }
}
