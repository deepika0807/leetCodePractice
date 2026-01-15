package geeksforgeeks.Arrays;

public class KadanesAlgorithm
{
    public static void main ( String[] args){
        int[] arr = {-1, -5};
        System.out.println(maxSubarraySum(arr));

    }

// Brute Force Solution
//    static int maxSubarraySum(int[] arr) {
//        int max = Integer.MIN_VALUE;
//        for ( int i=0; i< arr.length; i++ ){
//
//            for (int j=i; j< arr.length; j++ ){
//                int sum = 0;
//                for (int k= i; k<= j ; k++ ){
//                    sum = sum+arr[k];
//                }
//                max = Math.max(max, sum);
//
//            }
//
//        }
//     return max;
//    }



// Better Solution
//    static int maxSubarraySum(int[] arr) {
//        int max = Integer.MIN_VALUE;
//        for ( int i=0; i< arr.length; i++ ){
//            int sum = 0;
//            for (int j=i; j< arr.length; j++ ){
//                sum = sum+arr[j];
//                max = Math.max(max, sum);
//            }
//
//        }
//        return max;
//    }

//    Optimised solution (Kadane's Algorithm)
    static int maxSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for ( int i=0; i< arr.length; i++ ){
            sum += arr[i];
            max = Math.max (max, sum);
            if( sum < 0 ){
                sum = 0;
            }
        }
        return max;
}

}
