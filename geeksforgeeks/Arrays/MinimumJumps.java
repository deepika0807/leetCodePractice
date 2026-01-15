package geeksforgeeks.Arrays;

public class MinimumJumps
{
    public static void main(String[] args)
    {
        int[] arr = { 1, 1, 1, 1, 1, 1 };
        System.out.println(canJump(arr));
        System.out.println(minJumps(arr));
    }

    //    Can reach the final posistion (https://www.youtube.com/watch?v=Gtugy3mRV-A)
    static boolean canJump(int[] arr)
    {
        int finalPosition = arr.length - 1;
        for (int index = arr.length - 2; index >= 0; index--)
        {
            if (index + arr[index] >= finalPosition)
            {
                finalPosition = index;
            }
        }
        return finalPosition == 0;
    }

    // Minimum  Number of Jumps
    static int minJumps(int[] arr)
    {
        if (arr.length <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < arr.length; i++)
        {
            if (i == arr.length - 1)
                return jumps;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0)
            {
                jumps++;

                if (i >= maxReach)
                    return -1;

                steps = maxReach - i;
            }
        }

        return -1;
    }

}
