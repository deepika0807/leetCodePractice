package geeksforgeeks.Arrays;

public class LargestEleInArray
{
    public static void main(String[] angrs){
        int[] num = { 10, 3, 5, 2, 7, 7};
        findLargestEle(num);
        secondLargestEle(num);
        findLargestEleTwoPointer(num);
        findSecLargestEleTwoPointer(num);
    }

    public static void findLargestEle(int[] num){
        int largestEle = num[0];
        for(int i: num){
            if(i > largestEle){
                largestEle = i;
            }
        }
        System.out.println(largestEle);
    }
    public static void secondLargestEle(int[] num){
        int largestEle = num[0];
        int secLargestEle = -1;
        for(int i =1; i< num.length; i++){
            if( num[i] > largestEle ){
                secLargestEle = largestEle;
                largestEle = num[i];

            }else if(num[i] > secLargestEle && num[i] < largestEle){
                secLargestEle = num[i];
            }
        }
        System.out.println(largestEle);
        System.out.println(secLargestEle);
    }
    public static void findLargestEleTwoPointer(int[] num){
       int p1= 0;
       int largestEle = num[p1];
       int p2 = 1;
       while(p2 < num.length){
           if( num[p2] > num[p1]){
               largestEle = num[p2];
               p1=p2;
               p2++;
           }else{
               p2++;
           }
       }
        System.out.println(largestEle);
    }

    public static void findSecLargestEleTwoPointer(int[] num){
        int p1= 0;
        int largestEle = num[p1];
        int secLargestEle = Integer.MIN_VALUE;
        int p2 = 1;
        while(p2 < num.length){
            if( num[p2] > num[p1]){
                secLargestEle = largestEle;
                largestEle = num[p2];
                p1++;
                p2++;
            }else if (num[p2] > secLargestEle && num[p2] < largestEle){
                secLargestEle = num[p2];
                p2++;
            }else{
                p2++;
            }

        }
        System.out.println(largestEle);
        System.out.println(secLargestEle);
    }
}
