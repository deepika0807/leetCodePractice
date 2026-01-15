package geeksforgeeks.Arrays.LeetCode.TwoPointers;

import java.util.Arrays;
import java.util.Map;

public class TrappingRainWater
{
    public static void main(String[] args)
    {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trapBruteForce(height));
        System.out.println( trapBetter(height));
        System.out.println(trapOptimised(height));
    }
    public static int trapBruteForce(int[] height) {
        int result = 0;
        for ( int i=0; i< height.length; i++){
            int maxLeft = 0, maxRight = 0;
            for ( int j = 0; j<=i; j++){
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for ( int k=i; k< height.length; k++ ){
                maxRight = Math.max(maxRight, height[k]);
            }

            int waterTrap= Math.min(maxLeft, maxRight)-height[i];
            result = result + waterTrap;
        }
       return result;
    }

    public static int trapBetter(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i=1; i< n; i++ ){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n - 1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max( rightMax[i+1], height[i]);
        }
        int result = 0;
      for (int i=0; i< n ; i++){
          result = result + Math.min(leftMax[i], rightMax[i]) - height[i];
      }
      return result;
    }

    public static int trapOptimised(int[] height) {
        int n = height.length;
        int p1 = 0, p2 = n-1, lMax = 0, rMax = 0;
        int result = 0;
        while (p1 < p2 ){
            lMax = Math.max(lMax, height[p1]);
            rMax =  Math.max(rMax, height[p2]);
            if(lMax < rMax ){
                result = result + lMax - height[p1];
               p1++;
            }else{
                result = result + rMax - height[p2];
                p2--;
            }

        }
        return  result;
    }
}
