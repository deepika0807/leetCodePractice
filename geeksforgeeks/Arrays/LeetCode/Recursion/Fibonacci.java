package geeksforgeeks.Arrays.LeetCode.Recursion;

public class Fibonacci
{
    public static void main(String[] args)
    {
        System.out.println(fibonaci(5));
    }

     static int fibonaci(int n){
//        base condition
        if(n<2){
             return n;
        }
         return fibonaci(n-1) + fibonaci(n-2);
}
}
