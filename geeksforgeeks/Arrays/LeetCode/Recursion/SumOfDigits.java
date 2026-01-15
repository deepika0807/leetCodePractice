package geeksforgeeks.Arrays.LeetCode.Recursion;

public class SumOfDigits
{
    public static void main(String[] args)
    {
        System.out.println(sumOfDigits(1342));
    }
    static int sumOfDigits(int n){
        int num = n%10;
        if(n == 0){
            return 0;
        }
        return num + sumOfDigits(n/10);
    }
}
