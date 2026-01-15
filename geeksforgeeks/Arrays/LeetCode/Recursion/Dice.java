package geeksforgeeks.Arrays.LeetCode.Recursion;

//1155. Number of Dice Rolls With Target Sum
//https://www.youtube.com/watch?v=nQw9gVaIjGo
public class Dice
{
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args)
    {
        System.out.println(numRollsToTarget(2, 4, 6));
    }
    public static int numRollsToTarget(int n, int target, int face){
        final int MOD = 1_000_000_007;

        if(n==0){
            if(target == 0){
                return 1;
            }else{
                return 0;
            }
        }

        int sum=0;
        for(int i=1; i<=face && i <= target; i++){
            sum = (sum+ numRollsToTarget(n-1, target-i, face))% MOD;
        }
        return sum;
    }
}
