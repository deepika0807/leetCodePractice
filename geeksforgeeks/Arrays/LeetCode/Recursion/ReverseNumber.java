package geeksforgeeks.Arrays.LeetCode.Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNumber(1342)); // 2431
    }

    static int reverseNumber(int n) {
        return helper(n, 0);
    }

    static int helper(int n, int rev) {
        if (n == 0) return rev;

        return helper(n / 10, rev * 10 + n % 10);
    }
}
