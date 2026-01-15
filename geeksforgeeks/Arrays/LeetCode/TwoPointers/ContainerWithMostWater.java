package geeksforgeeks.Arrays.LeetCode.TwoPointers;

import static java.lang.Math.min;

import java.util.Arrays;

public class ContainerWithMostWater
{
    public static void main ( String args[] ){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right =height.length -1;
        int maxArea = 0;
        while ( left < right ){
            int area =  (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if ( height[left] < height[right]){
                left ++;
            }else{
                right -- ;
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height){
        int p1=0, p2 = height.length -1;
        int maxWater = 0;
        while(p1< p2){
            int area =0;
            if(height[p1]<height[p2]){
                area = (p2-p1) * height[p1];
                p1++;
            }else{
                area = (p2-p1) * height[p2];
                p2--;
            }
            maxWater = Math.max(maxWater, area);
        }
        return maxWater;
    }

}
